package com.example.relacionesentretablas.persona.infrastructure.controller.dto.output;

import com.example.relacionesentretablas.persona.domain.IPersona;
import com.example.relacionesentretablas.persona.domain.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonaDTOOutput implements IPersona {
    public PersonaDTOOutput(Persona persona) {

        setId(persona.getId());
        setUser(persona.getUser());
        setPassword(persona.getPassword());
        setSurname(persona.getSurname());
        setCompany_email(persona.getCompany_email());
        setPersonal_email(persona.getPersonal_email());
        setCity(persona.getCity());
        setActive(persona.getActive());
        setCreated_Date(persona.getCreated_Date());
        setImagen_url(persona.getImagen_url());
        setTermination_Date(persona.getTermination_Date());
    }

    Integer id;
    String user;
    String password;
    String surname;
    String company_email;
    String personal_email;
    String city;
    Boolean active;
    Date created_Date;
    String imagen_url;
    Date termination_Date;


}