package com.sistemaPreventivo.ProyectoRedes.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDto {

    @NotBlank(message = "El campo no debe ser solo espacios")
    @NotEmpty(message = "El campo no puede estar vacío")
    @Pattern(regexp = "^[A-Za-zÁ-Úá-úñÑ]+$", message = "El campo solo debe poseer letras y no contener espacios")
    private String nombreAlias;

    @NotBlank(message = "El campo no debe ser solo espacios")
    @NotEmpty(message = "El campo no puede estar vacío")
    @Pattern(regexp = "^[0-9]+$", message = "El numero telefónico solo debe poseer números")
    private String numeroTelefonico;

    @NotBlank(message = "El campo no debe ser solo espacios")
    @NotEmpty(message = "El campo no puede estar vacío")
    private String comentario;

}
