package com.example.relacionesentretablas.core;

import com.example.relacionesentretablas.core.error.CustomError;
import com.example.relacionesentretablas.core.error.NotFoundException;
import com.example.relacionesentretablas.core.error.UnprocesableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<?> handleNotFoundException(NotFoundException exception, WebRequest request) {
        CustomError error = new CustomError(new Date(), 404, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(UnprocesableException.class)
    public final ResponseEntity<?> handleUnProcesableException(UnprocesableException exception, WebRequest request) {
        CustomError error = new CustomError(new Date(), 422, exception.getMessage());
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);

    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public final ResponseEntity<?> handleBadRequest(HttpClientErrorException.BadRequest exception, WebRequest request) {
        CustomError error = new CustomError(new Date(), 500, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }
    @ExceptionHandler(RestClientException.class)
    public final ResponseEntity<?> handleRestClientException(RestClientException exception, WebRequest request) {
        CustomError error = new CustomError(new Date(), 503, exception.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);

    }



}