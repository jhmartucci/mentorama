package br.com.mentorama.produtos.controller;

import br.com.mentorama.produtos.models.Produto;
import br.com.mentorama.produtos.exceptions.*;
import br.com.mentorama.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> findAll(@RequestParam(required = false)String nome){
        try{
           return produtoService.findAll(nome);
        }catch (produtoNaoExisteException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
      @GetMapping("/id/{id}")
    public Produto buscaporId(@PathVariable("id")Integer id){
        try{
            return produtoService.buscaPorID(id);
        }catch (produtoNaoExisteException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<Integer> cadastra(@RequestBody Produto produto){
        produtoService.cadastra(produto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody Produto produto){
        produtoService.update(produto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
            produtoService.delete(id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
