package br.com.mentorama.olamundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olamundo")
public class OlaMundo {

    @GetMapping
    public String olaMundo(String mensagem){
        mensagem = "Olá Mundo!!!";
        return mensagem;
    }


}
