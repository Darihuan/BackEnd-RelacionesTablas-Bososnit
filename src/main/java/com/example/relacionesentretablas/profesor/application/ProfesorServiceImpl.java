package com.example.relacionesentretablas.profesor.application;

import com.example.relacionesentretablas.core.error.NotFoundException;
import com.example.relacionesentretablas.core.mapper.AuxMapper;
import com.example.relacionesentretablas.profesor.domain.Profesor;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.input.ProfesorDTOInput;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.input.ProfesorSearchInput;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.output.ProfesorDTOOutput;
import com.example.relacionesentretablas.profesor.infrastructure.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfesorServiceImpl implements IProfesorService {
    @Autowired
    ProfesorRepository repositorio;
    @Autowired
    AuxMapper mapper;

    @Override
    public ProfesorDTOOutput findProfesorbyID(Integer id) {
        Profesor profesor = repositorio.findById(id).orElseThrow(() -> new NotFoundException("no existe profesor con id:" + id));

        return mapper.createProfesorDTOOutput(profesor);
    }

    @Override
    public Optional<Profesor> findById(Integer id) {
        return repositorio.findById(id);
    }

    @Override
    public List<ProfesorDTOOutput> allProfesors() {
        List<Profesor> profesores = repositorio.findAll();
        List<ProfesorDTOOutput> profesoresDTO = new ArrayList();
        profesores.forEach(elemento -> profesoresDTO.add(mapper.createProfesorDTOOutput(elemento)));
        return profesoresDTO;
    }

    @Override
    public ProfesorDTOOutput saveProfesor(ProfesorDTOInput profesorDTO) {
        Profesor profesor = mapper.createProfesor(profesorDTO);
        repositorio.save(profesor);
        return mapper.createProfesorDTOOutput(profesor);


    }

    @Override
    public ProfesorDTOOutput updateProfesor(ProfesorDTOInput profesorDTO, Integer id) {
        Profesor profesor = repositorio.findById(id).orElseThrow(() -> new NotFoundException(" No Existe profesor con id:" + id));
        Profesor actualizar = mapper.createProfesor(profesorDTO);
        actualizar.setId(id);
        repositorio.save(actualizar);

        return mapper.createProfesorDTOOutput(actualizar);

    }

    @Override
    public void deleteProfesor(Integer id) {
        Profesor profesorBorrar = repositorio.findById(id).orElseThrow(() -> new NotFoundException(" No Existe profesor con id:" + id));
        repositorio.deleteById(id);


    }

    @Override
    public List<ProfesorDTOOutput> buscarProfesor(HashMap<String, Object> profesor) {

       List<Profesor> profesores=repositorio.getData(profesor);
        List<ProfesorDTOOutput> profesoresDTO = new ArrayList();
        profesores.forEach(elemento -> profesoresDTO.add(mapper.createProfesorDTOOutput(elemento)));
        return profesoresDTO;

        }
    }





