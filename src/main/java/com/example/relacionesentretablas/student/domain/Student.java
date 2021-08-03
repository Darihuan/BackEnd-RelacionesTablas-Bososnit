package com.example.relacionesentretablas.student.domain;

import com.example.relacionesentretablas.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.relacionesentretablas.persona.domain.Persona;
import com.example.relacionesentretablas.profesor.domain.Profesor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id_student;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name = "horas_por_semana")
    Integer num_hours_week;
    @Column(name = "comentarios")
    String coments;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profesor")
    Profesor profesor;
    @Column(name = "rama")
    String branch;
    @OneToMany
    List<Alumnos_Estudios> estudios;


}
