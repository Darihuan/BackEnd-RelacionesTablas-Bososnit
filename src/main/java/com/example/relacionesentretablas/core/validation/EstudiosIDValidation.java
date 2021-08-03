package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.alumnos_estudios.application.IAlumno_EstudioService;
import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.EstudiosIdValidationAnotation;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EstudiosIDValidation implements ConstraintValidator<EstudiosIdValidationAnotation, List<Integer>> {
    @Autowired
    IAlumno_EstudioService servicio;

    public void initialize(EstudiosIdValidationAnotation constraint) {
    }

    public boolean isValid(List<Integer> estudios, ConstraintValidatorContext context) {
        if (estudios != null) {

            estudios.forEach(estudiante -> servicio.findById(estudiante)
                    .orElseThrow(() -> new UnprocesableException("Error en la lista de alumnos no existe el alumno con id:" + estudiante)));
            return true;
        }
        return true;
    }
}
