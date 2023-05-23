package br.com.mentorama.ex10.movies.Repositories;

import br.com.mentorama.ex10.movies.Models.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, String> {
}
