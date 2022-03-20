package br.com.mentorama.filmes.controller;

import br.com.mentorama.filmes.entities.Filmes;
import br.com.mentorama.filmes.excepition.FilmesInexistenteException;
import br.com.mentorama.filmes.excepition.IlegalOcorrenciaException;
import br.com.mentorama.filmes.service.FilmesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmesController {
    @Autowired
    private FilmesService filmesService;

    @GetMapping
    public List<Filmes> findAll(@RequestParam(required = false) final String nome){
        try {
            return filmesService.findAll(nome);
        }catch (FilmesInexistenteException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/id/{id}")
    public Filmes buscaPorId(@PathVariable("id")Integer id){
        try {
            return filmesService.buscaPorId(id);
        }catch (FilmesInexistenteException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Filmes filmes){
        try {
            filmesService.add(filmes);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IlegalOcorrenciaException exception){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping
    public ResponseEntity update(@RequestBody final Filmes filmes){
        try {
            filmesService.update(filmes);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }catch (IlegalOcorrenciaException exception){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        filmesService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
