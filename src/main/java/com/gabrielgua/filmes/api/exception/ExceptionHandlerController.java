package com.gabrielgua.filmes.api.exception;

import com.gabrielgua.filmes.domain.exception.EmptyListException;
import com.gabrielgua.filmes.domain.exception.FilmeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandlerController {

    private Error createError(Map<String, Object> errors, HttpStatus status) {
        return Error.builder()
                .status(status.value())
                .errors(errors)
                .build();
    }

    @ExceptionHandler(FilmeNotFoundException.class)
    public ResponseEntity<?> handleFilmeNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EmptyListException.class)
    public ResponseEntity<?> handleEmptyList() {
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        var status = HttpStatus.UNPROCESSABLE_ENTITY;

        var errors = new HashMap<String, Object>();
        ex.getBindingResult().getFieldErrors().forEach(e -> {
            errors.put(e.getField(), e.getDefaultMessage());
        });

        var response = createError(errors, status);

        return new ResponseEntity<>(response, status);
    }

}
