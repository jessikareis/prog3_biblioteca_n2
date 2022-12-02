package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Professor;

public class ProfessorDao extends Dao<Professor> {
    public List<Professor> buscarTodos() {
        return em.createQuery("select c from Professor c order  by c.nome").getResultList();
    }

    public List<Professor> buscarTodosPorId() {
        return em.createQuery("select c from Professor c order by c.id").getResultList();
    }
}
