package br.com.mentorama.filmes.repository;

import br.com.mentorama.filmes.entities.Filmes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmesRepository {

    private final List<Filmes> filmesList;

    public FilmesRepository() {
        this.filmesList = new ArrayList<>();
    }
    public List<Filmes> findAll(final String nome){
        return filmesList.stream()
                .filter(fil-> fil.getNome().contains(nome))
                .collect(Collectors.toList());
    }
    public List<Filmes> findAll(){
        return filmesList;
    }
    public Filmes buscaPorId(Integer id){
        return filmesList.stream()
                .filter(fil-> fil.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public int count(){
        return filmesList.size();
    }

    public void add(final Filmes filmes){
        filmesList.add(filmes);
    }
    public void update(final Filmes filmes){
        filmesList.stream().filter(fil-> fil.getId().equals(filmes.getId()))
                .forEach(fil-> fil.setNome(filmes.getNome()));
        filmesList.stream().filter(fil-> fil.getId().equals(filmes.getId()))
                .forEach(fil-> fil.setNomeDiretor(filmes.getNomeDiretor()));
        filmesList.stream().filter(fil-> fil.getId().equals(filmes.getId()))
                .forEach(fil-> fil.setAno(filmes.getAno()));
        filmesList.stream().filter(fil-> fil.getId().equals(filmes.getId()))
                .forEach(fil-> fil.setNota(filmes.getNota()));
    }
    public void delete(Integer id){
        filmesList.removeIf(fil-> fil.getId().equals(id));
    }
}
