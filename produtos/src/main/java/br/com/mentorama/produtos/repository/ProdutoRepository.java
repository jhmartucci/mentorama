package br.com.mentorama.produtos.repository;

import br.com.mentorama.produtos.exceptions.produtoNaoExisteException;
import br.com.mentorama.produtos.models.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProdutoRepository {

    private final List<Produto> produtoList;

    public ProdutoRepository() {
        this.produtoList = new ArrayList<>();
    }
    public List<Produto> findAll(){
        return produtoList;
    }
    public List<Produto> findAll(String nome){
        return produtoList.stream()
                .filter(prod -> prod.getNome().contains(nome))
                .collect(Collectors.toList());
    }
    public Produto buscaPorId(Integer id){
        return produtoList.stream()
                .filter(prod-> prod.getId().equals(id))
                .findFirst()
                .orElseThrow(produtoNaoExisteException::new);
    }
    public int cont(){
        return produtoList.size();
    }
    public void cadastra(Produto produto){
        produtoList.add(produto);
    }
    public void update(Produto produto){
        produtoList.stream().filter(prod-> prod.getId().equals(produto.getId()))
                .forEach(prod-> prod.setNome(produto.getNome()));
        produtoList.stream().filter(prod-> prod.getId().equals(produto.getId()))
                .forEach(prod-> prod.setValor(produto.getValor()));
        produtoList.stream().filter(prod-> prod.getId().equals(produto.getId()))
                .forEach(prod-> prod.setQuantidadeEstoque(produto.getQuantidadeEstoque()));
        produtoList.stream().filter(prod-> prod.getId().equals(produto.getId()))
                .forEach(prod-> prod.setDescontoMaximo(produto.getDescontoMaximo()));
    }
    public void delete(Integer id){
        produtoList.removeIf(prod-> prod.getId().equals(id));
    }
}
