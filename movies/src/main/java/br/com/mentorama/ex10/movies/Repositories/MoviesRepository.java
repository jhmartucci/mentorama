package br.com.mentorama.ex10.movies.Repositories;

import br.com.mentorama.ex10.movies.Models.Movies;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MoviesRepository extends ReactiveCrudRepository<Movies, String> {
}
