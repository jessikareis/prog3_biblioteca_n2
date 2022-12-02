package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Leitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected String endereco;
    protected Long id;
    protected String telefone;
    protected String nome;
    protected Integer prazoMaxDevolucao;

    public static Long proxCod;

    public Leitor (){}
    public Leitor(String endereco, String telefone, String nome, Integer prazoMaxDevolucao) {
        this.endereco = endereco;
        this.telefone = telefone;
        this.nome = nome;
        this.prazoMaxDevolucao = prazoMaxDevolucao;
        this.id = proxCod;
        proxCod++;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPrazoMaxDevolucao() {
        return prazoMaxDevolucao;
    }

    public void setPrazoMaxDevolucao(Integer prazoMaxDevolucao) {
        this.prazoMaxDevolucao = prazoMaxDevolucao;
    }


}
