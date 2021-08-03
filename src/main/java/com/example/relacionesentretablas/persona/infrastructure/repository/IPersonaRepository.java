package com.example.relacionesentretablas.persona.infrastructure.repository;

import com.example.relacionesentretablas.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
    Optional<Persona> findByUser(String user);
    List<Persona> findAllByActive(Boolean active);
}
