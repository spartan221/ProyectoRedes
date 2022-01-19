package com.sistemaPreventivo.ProyectoRedes.repository;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;

public interface UsuarioRepository {


    void registrarUsuario(Usuario usuario);

    boolean isEmailInUse(String email);

}
