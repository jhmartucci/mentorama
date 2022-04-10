package br.com.mentorama.produtos.models;

public class Produto {
    private Integer id;
    private String nome;
    private double valor;
    private Integer quantidadeEstoque;
    private double descontoMaximo;

    public Produto(Integer id, String nome, double valor, Integer quantidadeEstoque, double descontoMaximo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.descontoMaximo = descontoMaximo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getDescontoMaximo() {
        return descontoMaximo;
    }

    public void setDescontoMaximo(double descontoMaximo) {
        this.descontoMaximo = descontoMaximo;
    }

    public double getPrecoComDesconto(final double desconto){
        if(desconto > descontoMaximo){
            return  valor * (1 - descontoMaximo);
        }else {
            return  valor * (1 - desconto);
        }
    }
    public Integer getQuantidadeVedas(Integer quantidadeVendida){
        if(quantidadeVendida > quantidadeEstoque){
            int diferenca;
            diferenca = quantidadeVendida - quantidadeEstoque;
            System.out.println("Houve uma quebra no pedido de " + diferenca +
                    "devido estar dísponivel no estoque a quantidade de " + quantidadeEstoque);
            return quantidadeEstoque;
        }else{
            return quantidadeVendida;
        }
    }
}
