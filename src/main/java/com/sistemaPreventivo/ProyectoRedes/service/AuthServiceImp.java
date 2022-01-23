package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import com.sistemaPreventivo.ProyectoRedes.repository.AuthRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements AuthService{

    @Autowired
    AuthRepository authRepository;

    @Override
    public boolean estaRegistrado(Usuario usuario) {
        Usuario usuarioBD = authRepository.getUserFromBD(usuario.getEmail());

        // Existe un usuario con el correo brindado
        if (usuarioBD != null){
            String passwordHashed = usuarioBD.getPassword();
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            return argon2.verify(passwordHashed, usuario.getPassword());
        }else{
            return false;
        }

    }
}
