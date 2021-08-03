package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.UsuarioValidationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidation implements ConstraintValidator<UsuarioValidationAnotation, String> {

    @Override
    public void initialize(UsuarioValidationAnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String user, ConstraintValidatorContext context) throws UnprocesableException {
        if (user != null) {
            int userlength = user.length();
            return userlength >= 6 || userlength <= 10;
        }
        throw new UnprocesableException("Error usuario no es valido");
    }
}