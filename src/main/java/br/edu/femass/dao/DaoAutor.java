package br.edu.femass.dao;
import java.util.List;
import br.edu.femass.model.Autor;

public class DaoAutor extends Dao<Autor>{
    public List<Autor> buscarTodos() {
        return em.createQuery("select c from Autor c order by c.nome").getResultList();
    }    
    
    public List<Autor> buscarTodosPorId() {
        return em.createQuery("select c from Autor c order by c.id").getResultList();
    } 

    // public List<Autor> buscarTodosPorNome() {
    //     return em.createQuery("select nome from Autor c order by c.nome").getResultList();
    // }   
}
