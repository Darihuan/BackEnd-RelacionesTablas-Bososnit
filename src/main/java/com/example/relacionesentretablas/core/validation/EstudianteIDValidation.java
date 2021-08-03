package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.EstudianteIDValidationAnotation;
import com.example.relacionesentretablas.student.application.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EstudianteIDValidation implements ConstraintValidator<EstudianteIDValidationAnotation, Integer> {
    @Autowired
    IStudentService servicio;

    @Override
    public void initialize(EstudianteIDValidationAnotation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer id, ConstraintValidatorContext context) {
        if (id != null) {

            servicio.findById(id).orElseThrow(() -> new UnprocesableException("No existe registro de estudiante con id:" + id));
            return true;
        }
        throw new UnprocesableException("El id de estudiante no puede ser nulo");

    }
}
