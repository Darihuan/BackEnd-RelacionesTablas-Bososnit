package com.example.relacionesentretablas.persona.application;

import com.example.relacionesentretablas.persona.domain.IPersona;
import com.example.relacionesentretablas.persona.domain.Persona;
import com.example.relacionesentretablas.persona.infrastructure.controller.dto.input.PersonaDTOInput;
import com.example.relacionesentretablas.persona.infrastructure.controller.dto.output.PersonaDTOOutput;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    IPersona findpersonabyID(Integer id);

    Optional<Persona> findById(Integer id);

    PersonaDTOOutput findpersonabyUser(String user);

    List<PersonaDTOOutput> allpersonas();

    PersonaDTOOutput savePersona(PersonaDTOInput personaDTO);

    PersonaDTOOutput updatePersona(PersonaDTOInput personaDTO, Integer id);

    void deletePersona(Integer id) throws Exception;


}