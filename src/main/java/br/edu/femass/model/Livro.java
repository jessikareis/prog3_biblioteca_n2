package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nome;
    private Long id;

    private ArrayList<Autor> autores;
    public static long proxCod = 1;

    private ArrayList<Exemplar> exemplares;

    public Livro() {
        this.autores = new ArrayList<>();
        this.exemplares = new ArrayList<>();
    }

    public Livro(String nome, Long id) {
        this.nome = nome;
        this.id = proxCod;
        proxCod++;
        this.autores = new ArrayList<>();
        this.exemplares = new ArrayList<>();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public static long getIdAtual() {
        proxCod++;
        return proxCod;
    }

    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }

    public void setExemplares(ArrayList<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }

    public static void atualizarProxCod(List<Livro> livros) {
        for (Livro livro : livros) {
            if (livro.getId() > proxCod) {
                proxCod = livro.getId();
                return;
            }
        }
    }

    @Override
    public String toString() {
        return (this.nome + ", " + this.getAutores().toString() + " Código: " + this.id);
    }

    @Override
    public boolean equals(Object obj) {
        Livro livro = (Livro) obj;
        return this.id.equals(livro.getId());
    }
}
