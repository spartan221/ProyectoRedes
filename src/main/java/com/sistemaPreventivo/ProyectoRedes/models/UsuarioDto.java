package com.sistemaPreventivo.ProyectoRedes.models;

import com.sistemaPreventivo.ProyectoRedes.utils.PasswordMatches;
import com.sistemaPreventivo.ProyectoRedes.utils.ValidEmail;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches(message = "Las contraseñas no coinciden")
public class UsuarioDto {

    @ValidEmail
    @NotNull
    @NotEmpty(message = "El campo no debe estar vacío")
    @NotBlank(message = "El campo no debe ser solo espacios")
    private String email;

    @NotNull
    @NotEmpty(message = "El campo no debe estar vacío")
    @NotBlank(message = "El campo no debe ser solo espacios")
    private String nombre;

    @NotNull
    @NotEmpty(message = "El campo no debe estar vacío")
    @NotBlank(message = "El campo no debe ser solo espacios")
    private String telefono;

    @NotNull
    @NotEmpty(message = "El campo no debe estar vacío")
    @NotBlank(message = "El campo no debe ser solo espacios")
    private String password;

    @NotEmpty(message = "El campo no debe estar vacío")
    @NotBlank(message = "El campo no debe ser solo espacios")
    private String matchingPassword;


}
