package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Comentario;
import com.sistemaPreventivo.ProyectoRedes.models.Reporte;
import com.sistemaPreventivo.ProyectoRedes.models.ReporteDto;
import com.sistemaPreventivo.ProyectoRedes.repository.ComentarioRepository;
import com.sistemaPreventivo.ProyectoRedes.repository.ReporteRepository;
import com.sistemaPreventivo.ProyectoRedes.utils.ReporteDoesntExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ReporteServiceImp implements ReporteService{

    @Autowired
    ReporteRepository reporteRepository;

    @Autowired
    ComentarioRepository comentarioRepository;


    @Override
    public Reporte consultarReporte(Long numeroTelefonico) throws ReporteDoesntExists{

        if (isReportedCreated(numeroTelefonico)){
            return reporteRepository.getReporteByNumeroTelefonico(numeroTelefonico);
        }else{
            throw new ReporteDoesntExists("No existe un reporte con el número telefónico: " +
                    numeroTelefonico.toString());
        }
    }

    @Override
    public void saveReporte(ReporteDto reporteDto) {
        Reporte reporte = new Reporte();
        reporte.setNombreAlias(reporteDto.getNombreAlias());
        reporte.setNumeroTelefonico(Long.parseLong(reporteDto.getNumeroTelefonico()));
        reporteRepository.save(reporte);

        //Guardar primer comentario del reporte realizado
        Comentario comentario = new Comentario();
        comentario.setReporte(reporteRepository.getReporteByNumeroTelefonico(Long.parseLong(reporteDto.getNumeroTelefonico())));
        comentario.setOpinion(reporteDto.getComentario());
        comentario.setFecha(Date.valueOf(LocalDate.now()));
        comentarioRepository.save(comentario);
    }

    private boolean isReportedCreated(Long numeroTelefonico) {
        return reporteRepository.getReporteByNumeroTelefonico(numeroTelefonico) != null;
    }

}
