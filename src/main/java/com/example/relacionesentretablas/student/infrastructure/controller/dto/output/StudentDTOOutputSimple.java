package com.example.relacionesentretablas.student.infrastructure.controller.dto.output;

import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output.Alumnos_EstudiosDTOOutputSimple;
import com.example.relacionesentretablas.persona.infrastructure.controller.dto.output.PersonaDTOOutput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDTOOutputSimple {

    Integer id_student;
    PersonaDTOOutput persona;
    Integer num_hours_week;
    String coments;
    String branch;
    List<Alumnos_EstudiosDTOOutputSimple> estudios;


}
