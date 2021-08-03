package com.example.relacionesentretablas.core.validation;


import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.EmailvalidationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidation implements ConstraintValidator<EmailvalidationAnotation, String> {


    @Override
    public void initialize(EmailvalidationAnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) throws UnprocesableException {
        if (email != null) {
            if (email.matches("^[^@]+@[^@]+\\.[a-zA-Z]{2,}$")) {
                return true;
            }
        }
        throw new UnprocesableException("El email no tine un formato correcto o es nulo");
    }
}