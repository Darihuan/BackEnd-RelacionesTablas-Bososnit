package com.example.relacionesentretablas.persona.application;

import com.example.relacionesentretablas.core.error.NotFoundException;
import com.example.relacionesentretablas.core.mapper.AuxMapper;
import com.example.relacionesentretablas.persona.domain.IPersona;
import com.example.relacionesentretablas.persona.domain.Persona;
import com.example.relacionesentretablas.persona.infrastructure.controller.dto.input.PersonaDTOInput;
import com.example.relacionesentretablas.persona.infrastructure.controller.dto.output.PersonaDTOOutput;
import com.example.relacionesentretablas.persona.infrastructure.repository.IPersonaRepository;
import com.example.relacionesentretablas.profesor.infrastructure.repository.ProfesorRepository;
import com.example.relacionesentretablas.student.infrastructure.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceimpl implements IPersonaService, UserDetailsService {
    @Autowired
    IPersonaRepository repositorio;
    @Autowired
    ProfesorRepository profesorRepositorio;
    @Autowired
    StudentRepository studentRepositorio;
    @Autowired
    AuxMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Persona persona = repositorio.findByUser(user).orElseThrow(()->new NotFoundException("No existe user:"+user));
      String permiso = persona.getAdmin()?"ADMIN":"USER";
      List<GrantedAuthority> rol = new ArrayList<>();
      if(permiso.equals("ADMIN")) {
          rol.add(new GrantedAuthority() {
              @Override
              public String getAuthority() {
                  return "ADMIN";
              }
          });
      }
      else if (permiso.equals("USER")) {
          rol.add(new GrantedAuthority() {
              @Override
              public String getAuthority() {
                  return "USER";
              }
          });
      }

        return new User(persona.getUser(),persona.getPassword(),rol);
    }
    @Override
    @Transactional
    public IPersona findpersonabyID(Integer id) {

        Persona persona = repositorio.findById(id).orElseThrow(() -> new NotFoundException("no existe usuario con id:" + id));
        if (profesorRepositorio.existsByPersona(persona))
            return mapper.createProfesorDTOOutput(profesorRepositorio.findAllByPersona(persona));
        if (studentRepositorio.existsByPersona(persona))
            return mapper.createStudentDTOOutput(studentRepositorio.findAllByPersona(persona));


        return new PersonaDTOOutput(persona);

    }

    @Override
    public Optional<Persona> findById(Integer id) {

        return repositorio.findById(id);

    }

    @Override
    @Transactional
    public PersonaDTOOutput findpersonabyUser(String user) {

        Persona persona = repositorio.findByUser(user).orElseThrow(() -> new NotFoundException("no existe usuario con user:" + user));

        return new PersonaDTOOutput(persona);

    }

    @Override
    @Transactional
    public List<PersonaDTOOutput> allpersonas() {

        List<Persona> personas = repositorio.findAll();
        List<PersonaDTOOutput> personasDTO = new ArrayList();
        personas.forEach(persona -> personasDTO.add(new PersonaDTOOutput(persona)));
        return personasDTO;
    }


    @Override
    @Transactional
    public PersonaDTOOutput savePersona(PersonaDTOInput personaDTO) {


        Persona persona = new Persona(personaDTO);

        repositorio.save(persona);

        return new PersonaDTOOutput(persona);

    }

    @Override
    @Transactional
    public PersonaDTOOutput updatePersona(PersonaDTOInput personaDTO, Integer id) {


        Persona persona = new Persona(personaDTO);

        Persona comprobarExistePersona = repositorio.findById(id).orElseThrow(() -> new NotFoundException("no existe usuario con id:" + id));

        repositorio.save(persona);

        return new PersonaDTOOutput(persona);

    }

    @Override
    @Transactional
    public void deletePersona(Integer id) {
        Persona borrado = repositorio.findById(id).orElseThrow(() -> new NotFoundException("no existe elemento con id:" + id + " para ser borrado"));
        repositorio.deleteById(id);
    }


}
