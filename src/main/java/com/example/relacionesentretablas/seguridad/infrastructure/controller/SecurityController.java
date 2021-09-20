package com.example.relacionesentretablas.seguridad.infrastructure.controller;

import com.example.relacionesentretablas.persona.application.PersonaServiceimpl;
import com.example.relacionesentretablas.persona.infrastructure.controller.dto.input.PersonaDTOInput;
import com.example.relacionesentretablas.seguridad.domain.PersonaResponse;
import com.example.relacionesentretablas.seguridad.infrastructure.controller.dto.input.LoginDtoInput;
import com.example.relacionesentretablas.seguridad.infrastructure.utility.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/personas")
public class SecurityController {
    @Autowired
    JWTUtil jwtUtil;
    @Autowired
    PersonaServiceimpl service;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("login")
    public ResponseEntity<PersonaResponse> login(@RequestBody LoginDtoInput validar) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(validar.getUsername(), validar.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        UserDetails userDetails = service.loadUserByUsername(validar.getUsername());
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.status(200).body(new PersonaResponse(token));

    }
}
