package br.com.mentorama.produtos.controller;

import br.com.mentorama.produtos.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    @ExceptionHandler({produtoNaoExisteException.class})
    public ResponseEntity produtoNaoExiste(final produtoNaoExisteException e){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
