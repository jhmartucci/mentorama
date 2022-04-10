package br.com.mentorama.produtos.models;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    @Test
    public void quandoPedidoConterAQuantidadeUmValorTotalDeveSerIgualValorUnitario(){
        Produto produto = new Produto(1, "5kg Arroz", 15.00, 4, 0);
        Pedido pedido = new Pedido(produto,1,0.0);
        Double resultado = pedido.precoTotalDoPedido();
        assertEquals(15,resultado);
    }

    @Test
    public void deveCalcularValorTotalDeCadaItemDoPedido(){
        Produto produto = new Produto(1, "5kg Arroz", 15.00, 4, 0);
        Pedido pedido = new Pedido(produto,4,0.0);
        Double resultado = pedido.precoTotalDoPedido();
        assertEquals(60,resultado);
    }
    @Test
    public void quandoPedidoMenorQueEstoqueDeveRecalcularQuantidadeEmEstoque(){
        Produto produto = new Produto(1, "Bala", 1.00, 50,0);
        Pedido pedido = new Pedido(produto,25,0.00);
        Integer resultado = (pedido.baixarEstoque(produto));
        assertEquals(25, resultado);
    }
    @Test
    public void quandoPedidoIgualAQuantidadeEmEstoqueDeveRetornarZero(){
        Produto produto = new Produto(1, "Bala", 1.00, 25,0);
        Pedido pedido = new Pedido(produto,25,0.00);
        Integer resultado = (pedido.baixarEstoque(produto));
        assertEquals(0, resultado);
    }
    @Test
    public void quandoPedidoMaiorQueAQuantidadeEmEstoqueDeveRetornarZero(){
        Produto produto = new Produto(1, "Bala", 1.00, 25,0);
        Pedido pedido = new Pedido(produto,50,0.00);
        Integer resultado = (pedido.baixarEstoque(produto));
        assertEquals(0, resultado);
    }
}
