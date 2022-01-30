package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Reporte;
import com.sistemaPreventivo.ProyectoRedes.utils.ReporteDoesntExists;

public interface ReporteService {

    Reporte consultarReporte(Long numeroTelefonico) throws ReporteDoesntExists; ;


}
