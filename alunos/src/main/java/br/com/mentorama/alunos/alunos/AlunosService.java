package br.com.mentorama.alunos.alunos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunosService {
    private final List<Alunos> alunosList;

    public AlunosService() {
        this.alunosList = new ArrayList<>();
    }
    public List<Alunos> buscaPorNome(String nome){
        if(nome != null){
            return this.alunosList
                    .stream()
                    .filter(al-> al.getNome().contains(nome))
                    .collect(Collectors.toList());
        }
        if(alunosList.isEmpty()){
            throw new AlunoInexistenteException();
        }
        return alunosList;
    }
    public Alunos buscaPorID(Integer id){
        return alunosList.stream()
                .filter(al-> al.getId().equals(id))
                .findFirst()
                .orElseThrow(AlunoInexistenteException::new);
    }
    public Alunos buscaPorIdade(Integer idade){
        return alunosList.stream()
                .filter(al-> al.getIdade().equals(idade))
                .findFirst()
                .orElseThrow(AlunoInexistenteException::new);
    }
    public ResponseEntity<Integer> cadastraAluno(Alunos alunos){
        if(alunos.getId() == null){
            alunos.setId(alunosList.size() + 1);
        }
        alunosList.add(alunos);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    public ResponseEntity alteraAluno(Alunos alunos){
        alunosList.stream()
                .filter(al-> al.getId().equals(alunos.getId()))
                .forEach(al-> al.setNome(alunos.getNome()));
        alunosList.stream()
                .filter(al-> al.getId().equals(alunos.getId()))
                .forEach(al-> al.setIdade(alunos.getIdade()));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    public ResponseEntity apagaAluno(Integer id){
        alunosList.removeIf(al-> al.getId().equals(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
