package br.edu.femass.dao;
import java.util.List;
import br.edu.femass.model.Leitor;

public class DaoLeitor extends Dao<Leitor>{

    public List<Leitor> buscarTodos() {
        return em.createQuery("select c from Leitor c order by c.nome").getResultList();
    }    
    
    public List<Leitor> buscarTodosPorId() {
        return em.createQuery("select c from Leitor c order by c.id").getResultList();
    }
    
}