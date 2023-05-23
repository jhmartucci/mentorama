package br.com.mentorama.ex10.movies.Service;

import br.com.mentorama.ex10.movies.Models.User;
import br.com.mentorama.ex10.movies.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<User> create(User user){
        return userRepository.save(user);
    }
    public Mono<User> findById(String id){
        return userRepository.findById(id);
    }
    public Flux<User> findAll(){
        return userRepository.findAll();
    }
}
