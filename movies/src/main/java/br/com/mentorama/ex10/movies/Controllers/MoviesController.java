package br.com.mentorama.ex10.movies.Controllers;

import br.com.mentorama.ex10.movies.Models.Movies;
import br.com.mentorama.ex10.movies.Service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    private MoviesService moviesService;
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping
    public Mono<ResponseEntity<Void>> create(@RequestBody Movies movies){
        jmsTemplate.convertAndSend("Movies", movies);
        System.out.println("Movie in line");
        return moviesService.create(movies)
                .map(x-> new ResponseEntity<>(HttpStatus.CREATED));
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<Movies>> findById(@PathVariable(value = "id")String id){
        return moviesService.findById(id)
                .map(x-> new ResponseEntity<>(x,HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    public Flux<ResponseEntity<Movies>> findAll(){
        return moviesService.fidnAll()
                .map(x-> new ResponseEntity<>(x, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
