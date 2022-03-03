package br.com.mentorama.alunos.alunos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    AlunosService alunosService = new AlunosService();


    @GetMapping
    public List<Alunos> buscaPorNome(@RequestParam(required = false) String nome){
        return alunosService.buscaPorNome(nome);
    }

    @GetMapping("/id/{id}")
    public Alunos buscaPorID(@PathVariable("id") Integer id){
        return alunosService.buscaPorID(id);
    }
    @GetMapping("/idade/{idade}")
    public Alunos buscaPorIdade(@PathVariable("idade") Integer idade){
        return alunosService.buscaPorIdade(idade);
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
