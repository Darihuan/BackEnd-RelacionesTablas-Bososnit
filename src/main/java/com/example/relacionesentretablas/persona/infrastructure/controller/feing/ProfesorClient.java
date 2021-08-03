package com.example.relacionesentretablas.persona.infrastructure.controller.feing;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "Profesor-client", url = "localhost:8085/api/v1/profesores",fallback = FeingFallbackFactory.class)

public interface ProfesorClient {

    @RequestMapping(method = RequestMethod.GET, value = "id/{id}")
    ResponseEntity<?> getprofesorbyid(@PathVariable("id") Integer id);
}
