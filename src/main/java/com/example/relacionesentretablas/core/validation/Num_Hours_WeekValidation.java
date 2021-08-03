package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.Num_Hours_WeekValidationAnotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Num_Hours_WeekValidation implements ConstraintValidator<Num_Hours_WeekValidationAnotation, Integer> {
    public void initialize(Num_Hours_WeekValidationAnotation constraint) {
    }

    public boolean isValid(Integer horas, ConstraintValidatorContext context) throws UnprocesableException {
        if (horas != null) {
            if (horas >= 0) {
                return true;
            }
            throw new UnprocesableException("La cantidad de horas por semana no puede ser negativa");
        }
        throw new UnprocesableException("La cantidad de horas por semana no puede ser nulo");
    }
}
