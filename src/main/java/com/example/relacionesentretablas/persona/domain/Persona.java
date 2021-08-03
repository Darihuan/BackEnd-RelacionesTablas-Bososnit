package com.example.relacionesentretablas.persona.domain;

import com.example.relacionesentretablas.persona.infrastructure.controller.dto.input.PersonaDTOInput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    @Id
    @Column(name = "id_persona")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "user", nullable = false)
    String user;
    @Column(name = "password", nullable = false)
    String password;
    @Column(name = "surname", nullable = false)
    String surname;
    @Column(name = "company_email", nullable = false)
    String company_email;
    @Column(name = "personal_email", nullable = false)
    String personal_email;
    @Column(name = "city", nullable = false)
    String city;
    @Column(name = "active", nullable = false)
    Boolean active;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    Date created_Date;
    @Column(name = "imagen_url")
    String imagen_url;
    @Column(name = "termination_date")
    Date termination_Date;

    public Persona(PersonaDTOInput personaDTO) {
        setId(personaDTO.getId());
        setUser(personaDTO.getUser());
        setPassword(personaDTO.getPassword());
        setSurname(personaDTO.getSurname());
        setCompany_email(personaDTO.getCompany_email());
        setPersonal_email(personaDTO.getPersonal_email());
        setCity(personaDTO.getCity());
        setActive(personaDTO.getActive());
        setCreated_Date(personaDTO.getCreated_Date());
        setImagen_url(personaDTO.getImagen_url());
        setTermination_Date(personaDTO.getTermination_Date());
    }
}
