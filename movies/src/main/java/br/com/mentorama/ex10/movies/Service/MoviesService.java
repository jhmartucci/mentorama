package br.com.mentorama.ex10.movies.Service;

import br.com.mentorama.ex10.movies.Models.Movies;
import br.com.mentorama.ex10.movies.Repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public Mono<Movies> create(Movies movies){
        return moviesRepository.save(movies);
    }
    public Mono<Movies> findById(String id){
        return moviesRepository.findById(id);
    }
    public Flux<Movies> fidnAll(){
        return moviesRepository.findAll();
    }
}
