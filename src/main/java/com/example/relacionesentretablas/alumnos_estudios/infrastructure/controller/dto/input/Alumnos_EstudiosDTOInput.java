package com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.input;

import com.example.relacionesentretablas.core.inputValidation.EstudianteIDValidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.InitialDateValidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.ProfesorIDValidationAnotation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Alumnos_EstudiosDTOInput {

    Integer id_study;
    @ProfesorIDValidationAnotation
    Integer idprofesor;
    @EstudianteIDValidationAnotation
    Integer IDStudent;
    String asignatura;
    String comment;
    @InitialDateValidationAnotation
    Date initial_date;
    Date finish_date;
}
