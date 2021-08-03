package com.example.relacionesentretablas.profesor.application;

import com.example.relacionesentretablas.profesor.domain.Profesor;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.input.ProfesorDTOInput;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.input.ProfesorSearchInput;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.output.ProfesorDTOOutput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IProfesorService {
    ProfesorDTOOutput findProfesorbyID(Integer id);

    Optional<Profesor> findById(Integer id);

    List<ProfesorDTOOutput> allProfesors();

    ProfesorDTOOutput saveProfesor(ProfesorDTOInput profesorDTO);

    ProfesorDTOOutput updateProfesor(ProfesorDTOInput profesorDTO, Integer id);

    void deleteProfesor(Integer id);

    List<ProfesorDTOOutput> buscarProfesor(HashMap<String,Object> profesor);
}
