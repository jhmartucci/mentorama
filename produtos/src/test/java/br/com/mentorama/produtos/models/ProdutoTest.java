package br.com.mentorama.produtos.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    public void quandoDescontoIgualDescontoMaximoDeveCalcularValorTotalComDesconto(){
        Produto produto = new Produto(1, "1 kg de Carne", 100.00, 1, 0.10);
        Double resultado = produto.getPrecoComDesconto(0.10);
        assertEquals(90.0, resultado);
    }

    @Test
    public void quandoDescontoMaiorQueOMaximoDeveAplicarDescontoMaximo(){
        Produto produto = new Produto(1, "1 litro de gasolina", 100.00,1,0.10);
        Double resultado = produto.getPrecoComDesconto(0.15);
        assertEquals(90.0, resultado);
    }

    @Test
    public void quandoDescontoMenorQueOMaxaimoDeveAplicaroDesconto(){
        Produto produto = new Produto(1, "5 kg Arroz",100.00, 1,0.10);
        Double resultado = produto.getPrecoComDesconto(0.05);
        assertEquals(95.0,resultado);
    }
    @Test
    public void quandoEstoqueForIgualEstoqueDisponivelDeveEfetivarAVenda(){
        Produto produto = new Produto(1, "Mouse", 15.00,5,0.10);
        Integer resultado = produto.getQuantidadeVedas(5);
        assertEquals(5, resultado);
    }

    @Test
    public void quandoEstoqueForMenorEstoqueDisponivelDeveEfetivarVenda(){
        Produto produto = new Produto(1, "Celular",1499.99,10,0.05);
        Integer resultado = produto.getQuantidadeVedas(2);
        assertEquals(2,resultado);
    }
    @Test
    public void quandoVendasForMaiorQueEstoqueDeveEfetuarAVendaComEstoqueDisponivel(){
        Produto produto = new Produto(1, "TV",3499.99,1,0.02);
        Integer resultado = produto.getQuantidadeVedas(2);
        assertEquals(1,resultado);
    }
}
