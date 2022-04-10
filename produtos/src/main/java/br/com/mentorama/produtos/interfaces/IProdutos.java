package br.com.mentorama.produtos.interfaces;

import br.com.mentorama.produtos.models.Produto;

import java.util.List;

public interface IProdutos {
    List<Produto> findAll(String nome);
    Produto buscaPorID(Integer id);
    Integer cadastra(Produto produto);
    void update(Produto produto);
    void delete(Integer id);
}
