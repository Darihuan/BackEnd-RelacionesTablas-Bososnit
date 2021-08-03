package com.example.relacionesentretablas.profesor.infrastructure.controller.dto.output;

import com.example.relacionesentretablas.persona.infrastructure.controller.dto.output.PersonaDTOOutput;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.output.StudentDTOOutputSimple;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfesorDTOOutputSimple {

    Integer id;
    PersonaDTOOutput persona;
    String coments;
    String branch;
    List<StudentDTOOutputSimple> students;

}
