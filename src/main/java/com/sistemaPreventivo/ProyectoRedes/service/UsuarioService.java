package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.ComentarioDto;
import com.sistemaPreventivo.ProyectoRedes.models.Reporte;
import com.sistemaPreventivo.ProyectoRedes.models.Usuario;
import com.sistemaPreventivo.ProyectoRedes.models.UsuarioDto;
import com.sistemaPreventivo.ProyectoRedes.utils.UserAlreadyExistException;

public interface UsuarioService {

    Usuario registerNewUserAccount(UsuarioDto usuarioDto) throws UserAlreadyExistException;

    boolean emailExists(String email);

    void makeComment(Reporte reporte, ComentarioDto comentarioDto);
}
