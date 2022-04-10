package br.com.mentorama.produtos.models;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TotalPedidoTest {

    @Test
    public void deveCalcularValorTotalDoPedido(){
        TotalPedido totalPedido = new TotalPedido();
        List<Pedido> pedidos = Arrays.asList(
                auxiliaValorTotalPedido(20.00),
                auxiliaValorTotalPedido(10.00),
                auxiliaValorTotalPedido(30.00));
        Double resultado = totalPedido.valorTotalPedido(pedidos);
        assertEquals(60,resultado);
    }

    private Pedido auxiliaValorTotalPedido(final Double valorEsperado){

        Pedido pedido = Mockito.mock(Pedido.class);
        Mockito.when(pedido.precoTotalDoPedido()).thenReturn(valorEsperado);
        return pedido;
    }

}