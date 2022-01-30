package com.sistemaPreventivo.ProyectoRedes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryReporteDto {

    @NotEmpty(message = "El campo no puede quedar vacío") @NotNull
    @NotBlank(message = "El campo no puede ser solo espacios")
    @Pattern(regexp = "^[0-9]+$", message = "El numero telefónico solo debe poseer números")
    private String numeroTelefonico;


}
