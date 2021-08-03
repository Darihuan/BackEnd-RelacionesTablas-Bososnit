package com.example.relacionesentretablas.persona.infrastructure.controller;

import com.example.relacionesentretablas.persona.application.IPersonaService;
import com.example.relacionesentretablas.persona.infrastructure.controller.dto.input.PersonaDTOInput;
import com.example.relacionesentretablas.persona.infrastructure.controller.feing.ProfesorClient;
import com.example.relacionesentretablas.profesor.infrastructure.controller.dto.output.ProfesorDTOOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/personas")
@EnableFeignClients
public class PersonaController {
    @Autowired
    IPersonaService service;
    @Autowired
    ProfesorClient profesorClient;
    @Autowired
    RestTemplate restTemplateInterceptor;

    @GetMapping("id/{id}")

    public ResponseEntity<?> findpersonabyID(@PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.findpersonabyID(id));

    }

    @GetMapping("user/{user}")

    public ResponseEntity<?> findpersonabyUser(@PathVariable("user") String user) throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.findpersonabyUser(user));


    }

    @GetMapping("")

    public ResponseEntity<?> allpersonas() throws Exception {

        return ResponseEntity.status(HttpStatus.OK).body(service.allpersonas());

    }

    /*Uso feing*/
    @GetMapping("/profesor/{id}")
    public ResponseEntity<?> getProfesor(@PathVariable("id")Integer id) throws Exception{
        ResponseEntity<?>entidad=ResponseEntity.status(HttpStatus.OK).body(profesorClient.getprofesorbyid(id));

        return ResponseEntity.status(HttpStatus.OK).body(entidad.getBody());

    }
    /*uso RestTemplate*/
    @GetMapping("profesor/rtemplate/{id}")
    public ResponseEntity<?> getProfesorRestTemplate(@PathVariable("id") Integer id) {
        ResponseEntity<ProfesorDTOOutput>entidad=restTemplateInterceptor.getForEntity("http://localhost:8085/api/v1/profesores/id/"+id, ProfesorDTOOutput.class);
        /*la gestion de errores se realiza en el core con el CustomizedExceptionHandler que devuleve un objeto error personalizado asi como un codigo de error especifico
        para las situaciones de bad request, not found error ,RestCLientException y unprocesable exception)*/
        return ResponseEntity.status(entidad.getStatusCodeValue()).body(entidad.getBody());

    }

    @PostMapping("")
    public ResponseEntity<?> savePersona(@RequestBody @Valid PersonaDTOInput personaDTO) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.savePersona(personaDTO));

    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<?> updatePersona(@RequestBody @Valid PersonaDTOInput personaDTO, @PathVariable("id") Integer id) throws Exception {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.updatePersona(personaDTO, id));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Integer id) throws Exception {

        service.deletePersona(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("persona borrada con exito");


    }
}
