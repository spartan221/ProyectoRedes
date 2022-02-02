package com.sistemaPreventivo.ProyectoRedes.service;

import com.sistemaPreventivo.ProyectoRedes.models.Comentario;
import com.sistemaPreventivo.ProyectoRedes.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioServiceImp implements ComentarioService{

    @Autowired
    ComentarioRepository comentarioRepository;


    @Override
    public List<Object[]> getTop5NumerosReportadosByNumberOfComments() {
        return comentarioRepository.top5NumerosReportados();
    }

    @Override
    public List<Comentario> getTop5NumerosReportadosRecent() {
        return comentarioRepository.topNumerosReportadosCommentedRecent(PageRequest.of(0, 5));
    }
}
