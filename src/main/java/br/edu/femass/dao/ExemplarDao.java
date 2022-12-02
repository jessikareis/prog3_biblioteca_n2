package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Exemplar;

public class ExemplarDao extends Dao<Exemplar> {
    public List<Exemplar> buscarTodos() {
        return em.createQuery("select c from Exemplar c order  by c.nome").getResultList();
    }

    public List<Exemplar> buscarTodosPorId() {
        return em.createQuery("select c from Exemplar c order by c.id").getResultList();
    }
}
