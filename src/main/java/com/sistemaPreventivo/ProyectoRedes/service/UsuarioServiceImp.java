package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import com.sistemaPreventivo.ProyectoRedes.models.UsuarioDto;
import com.sistemaPreventivo.ProyectoRedes.repository.UsuarioRepository;
import com.sistemaPreventivo.ProyectoRedes.utils.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario registerNewUserAccount(UsuarioDto usuarioDto) throws UserAlreadyExistException {
        if (emailExists(usuarioDto.getEmail())) {
            throw new UserAlreadyExistException("Ya existe una cuenta con el correo: "
                    + usuarioDto.getEmail());
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setNombre(usuarioDto.getNombre());
        usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        usuario.setTelefono(usuarioDto.getTelefono());
        usuario.setEnabled(true);
        usuario.setRole("USER");

        return usuarioRepository.save(usuario);

    }

    public boolean emailExists(String email) {
        return usuarioRepository.getUserByUsername(email) != null;
    }

    
}
