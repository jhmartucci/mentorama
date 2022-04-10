package br.com.mentorama.produtos.models;

public class Pedido {
    private Produto produto;
    private Integer quantidade;
    private Double desconto;

    public Pedido(Produto produto, Integer quantidade, Double desconto) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public Double precoTotalDoPedido(){
        return produto.getPrecoComDesconto(desconto) * quantidade;
    }
    public Integer baixarEstoque(Produto produto){
        if(quantidade <= produto.getQuantidadeEstoque()){
            produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - quantidade);
            return produto.getQuantidadeEstoque();
        }else{
            produto.setQuantidadeEstoque(0);
            return produto.getQuantidadeEstoque();
        }
    }

}
