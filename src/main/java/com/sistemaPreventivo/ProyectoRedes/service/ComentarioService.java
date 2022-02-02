package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Comentario;

import java.util.List;

public interface ComentarioService {

    List<Object[]> getTop5NumerosReportadosByNumberOfComments();
    List<Comentario> getTop5NumerosReportadosRecent();

}
