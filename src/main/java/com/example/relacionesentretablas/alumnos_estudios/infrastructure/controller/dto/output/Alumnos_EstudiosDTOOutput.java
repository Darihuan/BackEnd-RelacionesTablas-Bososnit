package com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output;

import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.output.ProfesorDTOOutput;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.output.StudentDTOOutput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Alumnos_EstudiosDTOOutput {

    Integer id_study;
    ProfesorDTOOutput profesor;
    StudentDTOOutput student;
    String asignatura;
    String comment;
    Date initial_date;
    Date finish_date;


}
