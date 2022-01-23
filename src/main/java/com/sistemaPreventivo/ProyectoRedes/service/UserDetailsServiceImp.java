package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.config.security.MyUserDetails;
import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import com.sistemaPreventivo.ProyectoRedes.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Usuario usuario = userRepository.getUserByUsername(email);

        if (usuario == null) {
            throw new UsernameNotFoundException("No se ha encontrado un usuario con el correo: " + email);
        }

        return new MyUserDetails(usuario);
    }


}
