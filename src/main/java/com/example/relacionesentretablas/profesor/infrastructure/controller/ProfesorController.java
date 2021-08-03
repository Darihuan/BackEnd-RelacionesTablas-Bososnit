package com.example.relacionesentretablas.profesor.infrastructure.controller;

import com.example.relacionesentretablas.profesor.application.IProfesorService;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.input.ProfesorDTOInput;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.output.ProfesorDTOOutput;
import com.example.relacionesentretablas.student.application.IStudentService;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.input.StudentDTOInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/v1/profesores")
public class ProfesorController {
    @Autowired
    IProfesorService service;
    @GetMapping("/buscar")
    public ResponseEntity<?> buscarProfesor( @RequestBody HashMap<String, Object> profesor){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarProfesor(profesor));
    }



    @GetMapping("id/{id}")

    public ResponseEntity<?> findProfesorbyID(@PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.findProfesorbyID(id));

    }


    @GetMapping("")

    public ResponseEntity<?> allProfesors() throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.allProfesors());

    }

    @PostMapping("")
    public ResponseEntity<?> saveProfesor(@RequestBody @Valid ProfesorDTOInput profesorDTO) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveProfesor(profesorDTO));

    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> updateProfesor(@RequestBody @Valid ProfesorDTOInput profesorDTO, @PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.updateProfesor(profesorDTO, id));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesor(@PathVariable("id") Integer id) throws Exception {

        service.deleteProfesor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("persona borrada con exito");

    }
}
