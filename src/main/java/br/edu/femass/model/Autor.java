package br.edu.femass.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String nacionalidade;
    public static Long proxCod;
    
    public Autor() {}

    public Autor(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.id = proxCod;
        proxCod++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    // @Override
    // public String toString() {
    //     return (this.nome + ", " + this.nacionalidade + ", " + this.id);
    // }

    public static Long getProxCod() {
        proxCod++;
        return proxCod;
    }

    @Override
    public boolean equals(Object obj) {
        Autor autor = (Autor) obj;
        return this.nome.equals(autor.getNome()) && this.nacionalidade.equals(autor.getNacionalidade());
    }

    public static void atualizarProxCod(List<Autor> autores){
        for (Autor autor : autores){
            if (autor.getId() > proxCod){
                proxCod = autor.getId();
                 return;
            }
        }
    }
}

