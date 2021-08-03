package com.example.relacionesentretablas.alumnos_estudios.infrastructure.repository;

import com.example.relacionesentretablas.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.relacionesentretablas.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Alumnos_EstudiosRepository extends JpaRepository<Alumnos_Estudios,Integer> {
}
