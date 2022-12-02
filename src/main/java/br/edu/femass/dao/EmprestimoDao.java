package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Emprestimo;

public class EmprestimoDao extends Dao<Emprestimo> {
    public List<Emprestimo> buscarTodos() {
        return em.createQuery("select c from Emprestimo c order  by c.nome").getResultList();
    }

    public List<Emprestimo> buscarTodosPorId() {
        return em.createQuery("select c from Emprestimo c order by c.id").getResultList();
    }
}
