package br.com.mentorama.produtos.service;


import br.com.mentorama.produtos.models.Produto;
import br.com.mentorama.produtos.exceptions.produtoNaoExisteException;
import br.com.mentorama.produtos.interfaces.IProdutos;
import br.com.mentorama.produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutos {


    @Autowired
    private ProdutoRepository produtoRepository;




    @Override
    public List<Produto> findAll(String nome) {
        if(nome != null){
            return produtoRepository.findAll(nome);
        }
        if(produtoRepository.findAll().isEmpty()){
            throw new produtoNaoExisteException();
        }
        return produtoRepository.findAll();
    }

    @Override
    public Produto buscaPorID(Integer id) {
        if(id != null){
            return produtoRepository.buscaPorId(id);
        }else{
            throw new produtoNaoExisteException();
        }
    }

    @Override
    public Integer cadastra(Produto produto) {
        if(produto.getId() == null){
            produto.setId(produtoRepository.cont() + 1);
        }
        produtoRepository.cadastra(produto);
        return produto.getId();
    }

    @Override
    public void update(Produto produto) {
        produtoRepository.update(produto);
    }

    @Override
    public void delete(Integer id) {
        produtoRepository.delete(id);
    }
}
