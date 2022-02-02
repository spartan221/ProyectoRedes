package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.*;
import com.sistemaPreventivo.ProyectoRedes.repository.ComentarioRepository;
import com.sistemaPreventivo.ProyectoRedes.repository.UsuarioRepository;
import com.sistemaPreventivo.ProyectoRedes.utils.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

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

    @Override
    public void makeComment(Reporte reporte, ComentarioDto comentarioDto) {
        Comentario comentario = new Comentario();
        comentario.setFecha(Date.valueOf(LocalDate.now()));
        comentario.setTimestamp(Timestamp.from(Instant.now()));
        comentario.setOpinion(comentarioDto.getComentarioText());
        comentario.setReporte(reporte);
        comentarioRepository.save(comentario);
    }


}
