package com.example.relacionesentretablas.student.infrastructure.controller.dto.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentSearchRequestModel {

    Integer id_student;
    Integer idpersona;
    Integer num_hours_week;
    String coments;
    Integer idprofesor;

}
