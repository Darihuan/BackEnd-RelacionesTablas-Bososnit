package com.example.relacionesentretablas.core.inputValidation;

import com.example.relacionesentretablas.core.validation.Num_Hours_WeekValidation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = Num_Hours_WeekValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Num_Hours_WeekValidationAnotation {
    String message() default "El numero de horas semanales no puede ser nulo y debe ser un numero entero positivo";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
