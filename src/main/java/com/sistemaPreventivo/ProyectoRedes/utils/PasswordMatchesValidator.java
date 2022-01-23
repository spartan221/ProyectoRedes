package com.sistemaPreventivo.ProyectoRedes.utils;

import com.sistemaPreventivo.ProyectoRedes.models.UsuarioDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UsuarioDto user = (UsuarioDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}