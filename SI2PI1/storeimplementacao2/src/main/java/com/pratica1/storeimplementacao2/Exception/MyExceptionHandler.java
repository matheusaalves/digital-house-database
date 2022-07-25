package com.pratica1.storeimplementacao2.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handlerBadRequest(BadRequestException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(ex.getMessage())
                        .fields("id")
                        .fieldsMessages("Id já existe")
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFound(BadRequestException ex) {
        return new ResponseEntity<>(
                ExceptionDetails.builder()
                        .title(ex.getMessage())
                        .fields("id")
                        .fieldsMessages("Não existe jóia com esse id")
                        .timestamp(LocalDateTime.now())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }
}
