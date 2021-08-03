package com.example.relacionesentretablas.student.infrastructure.controller.dto.input;

import com.example.relacionesentretablas.core.inputValidation.EstudiosIdValidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.Num_Hours_WeekValidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.PersonaIDValidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.ProfesorIDValidationAnotation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTOInput {

    Integer id_student;
    @PersonaIDValidationAnotation
    Integer idpersona;
    @Num_Hours_WeekValidationAnotation
    Integer num_hours_week;
    String coments;
    @ProfesorIDValidationAnotation
    Integer idprofesor;
    @EstudiosIdValidationAnotation
    List<Integer> estudios;

    String branch;
}
