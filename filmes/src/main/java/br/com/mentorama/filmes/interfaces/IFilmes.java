package br.com.mentorama.filmes.interfaces;

import br.com.mentorama.filmes.entities.Filmes;

import java.util.List;

public interface IFilmes {
    List<Filmes> findAll(final String nome);
    Filmes buscaPorId(Integer id);
    Integer add(Filmes filmes);
    void update(Filmes filmes);
    void delete(Integer id);
}
