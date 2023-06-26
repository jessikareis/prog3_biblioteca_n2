package br.edu.femass.model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Livro implements List<Livro> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected Long cod;
    public String titulo;
    @ManyToOne
    @JoinColumn(name = "autores_id")
    public Autor autores;

    // pensar que livro nao é um extend de autor e que livro é apenas um private
    // List<livro> livros;
    // acho que vai dar errado na hora de emprestar pq nao tera um id

    public Livro(String titulo, Long cod, Autor autores) {
        this.titulo = titulo;
        this.autores = autores;
        this.cod = cod;
    }

    public Livro() {

    }

    public Autor getAutores() {
        return autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    @Override
    public String toString() {
        return this.titulo;
    }

    @Override
    public int size() {

        return 0;
    }

    @Override
    public boolean isEmpty() {

        return false;
    }

    @Override
    public boolean contains(Object o) {

        return false;
    }

    @Override
    public Iterator<Livro> iterator() {

        return null;
    }

    @Override
    public Object[] toArray() {

        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        return null;
    }

    @Override
    public boolean add(Livro e) {

        return false;
    }

    @Override
    public boolean remove(Object o) {

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Livro> c) {

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Livro> c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Livro get(int index) {

        return null;
    }

    @Override
    public Livro set(int index, Livro element) {

        return null;
    }

    @Override
    public void add(int index, Livro element) {

    }

    @Override
    public Livro remove(int index) {

        return null;
    }

    @Override
    public int indexOf(Object o) {

        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {

        return 0;
    }

    @Override
    public ListIterator<Livro> listIterator() {

        return null;
    }

    @Override
    public ListIterator<Livro> listIterator(int index) {

        return null;
    }

    @Override
    public List<Livro> subList(int fromIndex, int toIndex) {

        return null;
    }

}
