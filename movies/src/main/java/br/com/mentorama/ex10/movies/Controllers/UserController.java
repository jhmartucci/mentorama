package br.com.mentorama.ex10.movies.Controllers;

import br.com.mentorama.ex10.movies.Models.User;
import br.com.mentorama.ex10.movies.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping
    public Mono<ResponseEntity<Void>> create(@RequestBody User user){
        jmsTemplate.convertAndSend("User", user);
        System.out.println("Queue user");
        return userService.create(user).map(x -> new ResponseEntity<>(HttpStatus.CREATED));
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<User>> findById(@PathVariable(value = "id") String id){
        return userService.findById(id)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping
    Flux<ResponseEntity<User>> findAll(){
        return userService.findAll()
                .map(x-> new ResponseEntity<>(x, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}


