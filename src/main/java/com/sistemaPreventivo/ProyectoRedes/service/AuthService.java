package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;

public interface AuthService {

    boolean estaRegistrado(Usuario usuario);

}
