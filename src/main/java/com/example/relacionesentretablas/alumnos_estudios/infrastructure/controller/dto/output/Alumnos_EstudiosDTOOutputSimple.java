package com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output;

import com.example.relacionesentretablas.alumnos_estudios.domain.Alumnos_Estudios;

import java.util.Date;

public class Alumnos_EstudiosDTOOutputSimple {
    Integer id_study;
    Integer profesorid;
    Integer studentid;
    String asignatura;
    String comment;
    Date initial_date;
    Date finish_date;

    public Alumnos_EstudiosDTOOutputSimple(Alumnos_Estudios estudios) {
        id_study = estudios.getId_study();
        profesorid = estudios.getProfesor().getId();
        studentid = estudios.getStudent().getId_student();
        asignatura = estudios.getAsignatura();
        comment = estudios.getComment();
        initial_date = estudios.getInitial_date();
        finish_date = estudios.getFinish_date();

    }
}
