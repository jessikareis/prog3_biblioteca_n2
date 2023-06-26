package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Autor {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autores")
    private List<Livro> livros;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nome;
    protected String nacionalidade;
    public static Long proxCod;

    public Autor() {
    }

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

    @Override
    public String toString() {
        return (this.nome + ", " + this.nacionalidade);
    }

    public static Long getProxCod() {
        proxCod++;
        return proxCod;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
    // @Override
    // public boolean equals(Object obj) {
    // Autor autor = (Autor) obj;
    // // return
    // this.nome.equals(autor.getNome())&&this.nacionalidade.equals(autor.getNacionalidade());
    // return this.nome.equals(autor.getNome());
    // }

    public static void atualizarProxCod(List<Autor> autores) {
        for (Autor autor : autores) {
            if (autor.getId() > proxCod) {
                proxCod = autor.getId();
                return;
            }
        }
    }

    public void adicionarLivros(String titulo, long cod, Autor autores) {
        if (livros == null)
            livros = new ArrayList();
        livros.add(new Livro(titulo, cod, autores));
    }
}
