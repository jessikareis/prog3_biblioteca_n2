package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Aluno;

public class AlunoDao extends Dao<Aluno> {
    public List<Aluno> buscarTodos() {
        return em.createQuery("select c from Aluno c order  by c.nome").getResultList();
    }

    public List<Aluno> buscarTodosPorId() {
        return em.createQuery("select c from Aluno c order by c.id").getResultList();
    }
}
