package com.example.relacionesentretablas.profesor.infrastructure.controller.dto.input;


import com.example.relacionesentretablas.core.inputValidation.ListaIDEstudiantesValidationAnotation;
import com.example.relacionesentretablas.core.inputValidation.PersonaIDValidationAnotation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProfesorSearchInput {

    Integer id;
    Integer idPersona;
    String coments;
    String branch;
}
