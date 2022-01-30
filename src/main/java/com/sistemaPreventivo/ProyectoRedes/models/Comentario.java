package com.sistemaPreventivo.ProyectoRedes.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "comentario")
@ToString
@EqualsAndHashCode
public class Comentario {

    @Id
    @Getter @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_reporte", nullable = false, updatable = false)
    @Getter @Setter
    private Reporte reporte;

    @Getter @Setter @Column(name = "fecha")
    private Date fecha;

    @Getter @Setter @Column(name = "opinion")
    private String opinion;


}
