package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Autor;

public class AutorDao extends Dao<Autor> {
    public List<Autor> buscarTodos() {
        return em.createQuery("select c from Autor c order  by c.nome").getResultList();
    }

    public List<Autor> buscarTodosPorId() {
        return em.createQuery("select c from Autor c order by c.id").getResultList();
    }
}
