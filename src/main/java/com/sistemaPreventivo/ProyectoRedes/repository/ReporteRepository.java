package com.sistemaPreventivo.ProyectoRedes.repository;

import com.sistemaPreventivo.ProyectoRedes.models.Reporte;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ReporteRepository extends CrudRepository<Reporte, Long> {

    @Query("SELECT r FROM Reporte r WHERE r.numeroTelefonico = :numeroTelefonico")
    public Reporte getReporteByNumeroTelefonico(@Param("numeroTelefonico") Long numeroTelefonico);
}
