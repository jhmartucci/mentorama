package br.com.mentorama.filmes.controller;

import br.com.mentorama.filmes.excepition.FilmesInexistenteException;
import br.com.mentorama.filmes.excepition.IdRepetidoException;
import br.com.mentorama.filmes.excepition.IlegalOcorrenciaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    @ExceptionHandler({FilmesInexistenteException.class})
    public ResponseEntity inexistente(final FilmesInexistenteException exception){
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({IdRepetidoException.class})
    public ResponseEntity IDrepetido(final  IdRepetidoException exception){
        return new ResponseEntity(HttpStatus.CONFLICT);
    }
    @ExceptionHandler({IlegalOcorrenciaException.class})
    public ResponseEntity ilegalOcorrencias(final IlegalOcorrenciaException exception){
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
