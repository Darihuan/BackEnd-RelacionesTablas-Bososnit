package com.example.relacionesentretablas.alumnos_estudios.application;

import com.example.relacionesentretablas.alumnos_estudios.domain.Alumnos_Estudios;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.input.Alumnos_EstudiosDTOInput;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output.Alumnos_EstudiosDTOOutput;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.output.Alumnos_EstudiosDTOOutputSimple;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.repository.Alumnos_EstudiosRepository;
import com.example.relacionesentretablas.core.error.NotFoundException;
import com.example.relacionesentretablas.core.mapper.AuxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Alumnos_EstudiosService implements IAlumno_EstudioService {
    @Autowired
    Alumnos_EstudiosRepository repository;
    @Autowired
    AuxMapper mapper;

    @Override
    public Alumnos_EstudiosDTOOutput findEstudiosbyID(Integer id) {
        Alumnos_Estudios estudios = repository.findById(id).orElseThrow(() -> new NotFoundException("no existen los estudios con id:" + id));

        return mapper.createAlumnos_EstudiosDTOOutput(estudios);

    }

    @Override
    public Optional<Alumnos_Estudios> findById(Integer estudiante) {
        return repository.findById(estudiante);
    }

    @Override
    public List<Alumnos_EstudiosDTOOutput> allEstudios() {
        List<Alumnos_Estudios> estudios = repository.findAll();
        List<Alumnos_EstudiosDTOOutput> estudiosDTO = new ArrayList();
        estudios.forEach(elemento -> estudiosDTO.add(mapper.createAlumnos_EstudiosDTOOutput(elemento)));
        return estudiosDTO;

    }

    @Override
    public Alumnos_EstudiosDTOOutputSimple saveEstudios(Alumnos_EstudiosDTOInput relacionDTO) {
        Alumnos_Estudios estudios = mapper.createAlumnos_Estudios(relacionDTO);
        repository.save(estudios);
        return new Alumnos_EstudiosDTOOutputSimple(estudios);
    }

    @Override
    public Alumnos_EstudiosDTOOutputSimple updateEstudios(Alumnos_EstudiosDTOInput estudiosDTO, Integer id) {
        Alumnos_Estudios estudios = repository.findById(id).orElseThrow(() -> new NotFoundException(" No Existen estudios con este  id:" + id));
        Alumnos_Estudios actualizar = mapper.createAlumnos_Estudios(estudiosDTO);
        actualizar.setId_study(id);
        repository.save(actualizar);

        return new Alumnos_EstudiosDTOOutputSimple(actualizar);
    }

    @Override
    public void deleteEstudios(Integer id) {
        Alumnos_Estudios estudios = repository.findById(id).orElseThrow(() -> new NotFoundException(" No Existen estudios con este  id:" + id));
        repository.deleteById(id);
    }
}
