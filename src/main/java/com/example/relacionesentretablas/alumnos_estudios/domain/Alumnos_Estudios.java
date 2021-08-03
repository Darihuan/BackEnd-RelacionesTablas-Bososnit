package com.example.relacionesentretablas.alumnos_estudios.domain;

import com.example.relacionesentretablas.profesor.domain.Profesor;
import com.example.relacionesentretablas.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "estudios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Alumnos_Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_study;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    Profesor profesor;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    Student student;
    @Column(name = "asignatura")
    String asignatura;
    @Column(name = "comentarios")
    String comment;
    @Column(name = "initial_date")
    Date initial_date;
    @Column(name = "finish_date")
    Date finish_date;


}
