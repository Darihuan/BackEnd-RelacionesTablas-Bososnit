package com.example.relacionesentretablas.core.validation;

import com.example.relacionesentretablas.core.error.UnprocesableException;
import com.example.relacionesentretablas.core.inputValidation.ListaIDEstudiantesValidationAnotation;
import com.example.relacionesentretablas.student.application.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class ListaIDEstudiantesValidation implements ConstraintValidator<ListaIDEstudiantesValidationAnotation, List<Integer>> {

    @Autowired
    IStudentService servicio;

    public void initialize(ListaIDEstudiantesValidationAnotation constraint) {
    }

    public boolean isValid(List<Integer> grupoStudents, ConstraintValidatorContext context) throws UnprocesableException {
        if (grupoStudents != null) {
            grupoStudents.forEach(estudiante -> servicio.findById(estudiante)
                    .orElseThrow(() -> new UnprocesableException("Error en la lista de alumnos no existe el alumno con id:" + estudiante)));
            return true;
        }
        return true;
    }
}
