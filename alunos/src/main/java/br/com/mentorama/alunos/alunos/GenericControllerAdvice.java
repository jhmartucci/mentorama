package br.com.mentorama.alunos.alunos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {

    @ExceptionHandler({AlunoInexistenteException.class})
    public ResponseEntity verificaExeptions(final AlunoInexistenteException exception){
        return new ResponseEntity("Aluno não existe!", HttpStatus.NOT_FOUND);
    }

}
