package com.example.relacionesentretablas.student.infrastructure.controller;

import com.example.relacionesentretablas.alumnos_estudios.application.IAlumno_EstudioService;
import com.example.relacionesentretablas.alumnos_estudios.infrastructure.controller.dto.input.Alumnos_EstudiosDTOInput;
import com.example.relacionesentretablas.student.application.IStudentService;
import com.example.relacionesentretablas.student.infrastructure.controller.dto.input.StudentDTOInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/estudiantes")
public class StudentController {
    @Autowired
    IStudentService service;
    @Autowired
    IAlumno_EstudioService service_estudios;

    @GetMapping("id/{id}")

    public ResponseEntity<?> findStudentbyID(@PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.findStudentbyID(id));

    }


    @GetMapping("")

    public ResponseEntity<?> allStudents() throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.allStudents());

    }

    @PostMapping("")
    public ResponseEntity<?> saveStudent(@RequestBody @Valid StudentDTOInput studentDTO) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveStudent(studentDTO));

    }

    @PostMapping("/estudios")
    public ResponseEntity<?> saveEstudios(@RequestBody @Valid Alumnos_EstudiosDTOInput curso) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service_estudios.saveEstudios(curso));

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody @Valid StudentDTOInput studentDTO, @PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.updateStudent(studentDTO, id));

    }

    @PutMapping("/estudios/{id}")
    public ResponseEntity<?> updateEstudios(@RequestBody @Valid Alumnos_EstudiosDTOInput curso, @PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service_estudios.updateEstudios(curso, id));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id) throws Exception {

        service.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("persona borrada con exito");

    }

    @DeleteMapping("estudios/{id}")
    public ResponseEntity<?> deleteEstudios(@PathVariable("id") Integer id) throws Exception {

        service_estudios.deleteEstudios(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("persona borrada con exito");

    }


}
