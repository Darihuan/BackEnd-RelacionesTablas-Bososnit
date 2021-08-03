package com.example.relacionesentretablas.student.infrastructure.repository;

import com.example.relacionesentretablas.persona.domain.Persona;
import com.example.relacionesentretablas.profesor.domain.Profesor;
import com.example.relacionesentretablas.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findAllByPersona(Persona persona);
    Boolean existsByPersona(Persona persona);
}
