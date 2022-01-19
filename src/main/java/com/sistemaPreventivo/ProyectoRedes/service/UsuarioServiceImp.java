package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import com.sistemaPreventivo.ProyectoRedes.repository.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public boolean registrarUsuario(Usuario usuario) {
        if (validarDatosRegistroUsuario(usuario) && !isEmailInUse(usuario.getEmail())){
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
            String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
            usuario.setPassword(hash);
            usuarioRepository.registrarUsuario(usuario);
            return true;
        }
        return false;
    }

    private boolean isEmailInUse(String email) {
        return usuarioRepository.isEmailInUse(email);
    }

    private boolean validarDatosRegistroUsuario(Usuario usuario) {
        return validarEmail(usuario.getEmail())
                && validarNombre(usuario.getNombre())
                && validarTelefono(usuario.getTelefono())
                && validarPassword(usuario.getPassword());
    }

    private boolean validarNombre(String nombre) {
        Pattern pattern =
                Pattern.compile("^[A-Za-z]\\w{3,29}$");
        Matcher matcher = pattern.matcher(nombre);
        return matcher.matches();
    }

    private boolean validarEmail(String email) {
        Pattern pattern =
                Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    private boolean validarTelefono(String telefono){
        Pattern pattern =
                Pattern.compile("^3[0-9]{9}$");
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();
    }

    private boolean validarPassword(String password){
        Pattern pattern =
                Pattern.compile("^[A-za-z0-9]{8,20}$");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
