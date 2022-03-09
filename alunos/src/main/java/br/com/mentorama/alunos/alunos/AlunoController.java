package br.com.mentorama.alunos.alunos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    AlunosService alunosService = new AlunosService();

    @GetMapping
    public List<Alunos> buscaPorNome(@RequestParam(required = false) String nome){
        try {
            return alunosService.buscaPorNome(nome);
        }
        catch (AlunoInexistenteException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    public Alunos buscaPorID(@PathVariable("id") Integer id){
        try {
            return alunosService.buscaPorID(id);
        }catch (AlunoInexistenteException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/idade/{idade}")
    public Alunos buscaPorIdade(@PathVariable("idade") Integer idade){
        try {
            return alunosService.buscaPorIdade(idade);
        }catch (AlunoInexistenteException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> cadastraAluno(@RequestBody final Alunos alunos){
        return alunosService.cadastraAluno(alunos);
    }

    @PutMapping
    public ResponseEntity alteraAluno(@RequestBody final Alunos alunos){
        return alunosService.alteraAluno(alunos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletaAluno(@PathVariable("id") Integer id){
        return alunosService.apagaAluno(id);
    }
}
