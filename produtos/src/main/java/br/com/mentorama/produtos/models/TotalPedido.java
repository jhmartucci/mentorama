package br.com.mentorama.produtos.models;

import java.util.List;

public class TotalPedido {
    public Double valorTotalPedido(final List<Pedido> pedidos){
        return pedidos.stream()
                .mapToDouble(Pedido::precoTotalDoPedido)
                .sum();
    }
}
