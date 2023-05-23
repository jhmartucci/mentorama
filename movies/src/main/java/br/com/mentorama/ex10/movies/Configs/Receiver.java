package br.com.mentorama.ex10.movies.Configs;

import br.com.mentorama.ex10.movies.Models.Movies;
import br.com.mentorama.ex10.movies.Models.User;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "movies", containerFactory = "myFactory")
    public void receiveMovies(Movies movies){
        if(movies.getUsuarioId() == null){
            throw new RuntimeException("Invalid Movies");
        }
        System.out.println("Review sent to queue <" + movies + ">");
    }
    @JmsListener(destination = "users", containerFactory = "myFactory")
    public void receiveUsers(User user){
        if(user.getIdUser() == null){
            throw new RuntimeException("User does not exist");
        }
        System.out.println("User sent to queue <" + user + ">");
    }
}
