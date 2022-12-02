package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Livro;

public class LivroDao extends Dao<Livro> {
    public List<Livro> buscarTodos() {
        return em.createQuery("select c from Livro c order  by c.nome").getResultList();
    }

    public List<Livro> buscarTodosPorId() {
        return em.createQuery("select c from Livro c order by c.id").getResultList();
    }

}
