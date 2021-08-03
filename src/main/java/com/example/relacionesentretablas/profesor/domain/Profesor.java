package com.example.relacionesentretablas.profesor.domain;

import com.example.relacionesentretablas.persona.domain.Persona;
import com.example.relacionesentretablas.student.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    @OneToOne
    @JoinColumn(name = "id_persona")
    Persona persona;
    @Column(name = "comentarios")
    String coments;
    @Column(name = "rama")
    String branch;
    @OneToMany
    List<Student> students;


}
