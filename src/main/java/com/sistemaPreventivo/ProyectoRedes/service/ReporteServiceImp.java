package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Reporte;
import com.sistemaPreventivo.ProyectoRedes.repository.ReporteRepository;
import com.sistemaPreventivo.ProyectoRedes.utils.ReporteDoesntExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReporteServiceImp implements ReporteService{

    @Autowired
    ReporteRepository reporteRepository;


    @Override
    public Reporte consultarReporte(Long numeroTelefonico) throws ReporteDoesntExists{

        if (isReportedCreated(numeroTelefonico)){
            return reporteRepository.getReporteByNumeroTelefonico(numeroTelefonico);
        }else{
            throw new ReporteDoesntExists("No existe un reporte con el número telefónico: " +
                    numeroTelefonico.toString());
        }
    }

    private boolean isReportedCreated(Long numeroTelefonico) {
        return reporteRepository.getReporteByNumeroTelefonico(numeroTelefonico) != null;
    }

}
