package com.sistemaPreventivo.ProyectoRedes.repository;

import com.sistemaPreventivo.ProyectoRedes.models.Comentario;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComentarioRepository extends CrudRepository<Comentario, Long> {

    @Query(value = "SELECT comentario.id_reporte, COUNT(comentario.id)\n" +
            "\tFROM comentario\n" +
            "        GROUP BY comentario.id_reporte\n" +
            "        \tORDER BY COUNT(comentario.id_reporte) DESC\n" +
            "            LIMIT 5;", nativeQuery = true)
    List<Object[]> top5NumerosReportados();

    @Query("SELECT c FROM Comentario c ORDER BY c.timestamp DESC")
    List<Comentario> topNumerosReportadosCommentedRecent(PageRequest pageRequest);

}
