package br.com.mentorama.filmes.entities;

public class Filmes {
    private Integer id;
    private String nome;
    private String nomeDiretor;
    private Integer ano;
    private Integer nota;

    public Filmes(Integer id, String nome, String nomeDieretor, Integer ano, Integer nota) {
        this.id = id;
        this.nome = nome;
        this.nomeDiretor = nomeDieretor;
        this.ano = ano;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeDiretor(String nomeDiretor) {
        this.nomeDiretor = nomeDiretor;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getNomeDiretor() {
        return nomeDiretor;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getNota() {
        return nota;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
