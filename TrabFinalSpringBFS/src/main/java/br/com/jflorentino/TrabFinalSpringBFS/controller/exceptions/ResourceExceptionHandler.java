package br.com.jflorentino.TrabFinalSpringBFS.controller.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	//Excessõse de objetos não encontrados nas buscas
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<String> entityNotFoundException(EntityNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
