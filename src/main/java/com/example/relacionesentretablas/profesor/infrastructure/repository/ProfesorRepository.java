package com.example.relacionesentretablas.profesor.infrastructure.repository;

import com.example.relacionesentretablas.persona.domain.Persona;
import com.example.relacionesentretablas.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.HashMap;
import java.util.List;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {
    List<Profesor> getData(HashMap<String, Object> conditions);

    Profesor findAllByPersona(Persona persona);

    Boolean existsByPersona(Persona persona);
}
