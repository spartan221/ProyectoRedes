package com.sistemaPreventivo.ProyectoRedes.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reporte")
@ToString @EqualsAndHashCode
@JsonIgnoreProperties("comentarios")
public class Reporte{

    @Id
    @Getter @Setter @Column(name = "numero_telefonico")
    private Long numeroTelefonico;

    @Getter @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reporte")
    private List<Comentario> comentarios;

    @Getter @Setter @Column(name = "nombre_alias")
    private String nombreAlias;

}
