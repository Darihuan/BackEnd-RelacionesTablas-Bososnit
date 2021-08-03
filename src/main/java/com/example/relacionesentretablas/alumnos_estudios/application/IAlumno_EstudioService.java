package com.example.relacionesentretablas.alumnos_estudios.application;

import com.example.relacionesentretablas.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.input.Alumnos_EstudiosDTOInput;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output.Alumnos_EstudiosDTOOutput;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output.Alumnos_EstudiosDTOOutputSimple;

import java.util.List;
import java.util.Optional;


public interface IAlumno_EstudioService {
    Alumnos_EstudiosDTOOutput findEstudiosbyID(Integer id);

    Optional<Alumnos_Estudios> findById(Integer estudiante);

    List<Alumnos_EstudiosDTOOutput> allEstudios();

    Alumnos_EstudiosDTOOutputSimple saveEstudios(Alumnos_EstudiosDTOInput relacionDTO);

    Alumnos_EstudiosDTOOutputSimple updateEstudios(Alumnos_EstudiosDTOInput racionDTO, Integer id);

    void deleteEstudios(Integer id);
}
