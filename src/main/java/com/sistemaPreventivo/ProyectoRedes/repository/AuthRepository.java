package com.sistemaPreventivo.ProyectoRedes.repository;

import com.sistemaPreventivo.ProyectoRedes.models.Usuario;

public interface AuthRepository {

    Usuario getUserFromBD(String email);


}
