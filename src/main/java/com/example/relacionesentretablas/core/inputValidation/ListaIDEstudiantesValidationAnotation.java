package com.example.relacionesentretablas.core.inputValidation;

import com.example.relacionesentretablas.core.validation.ListaIDEstudiantesValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ListaIDEstudiantesValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ListaIDEstudiantesValidationAnotation {
    String message() default "La lista de estudiantes debe contener ID que exitan en la base de datos";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
