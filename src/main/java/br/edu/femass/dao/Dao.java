package br.edu.femass.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao<E> {

    protected static EntityManagerFactory emf;
    protected static EntityManager em;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("jpa_prog3");
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Dao() {
        em = emf.createEntityManager();
    }

    public void inserir(E entidade) {
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
    }

    public void apagar(E entidade) {
        em.getTransaction().begin();
        em.remove(entidade);
        em.getTransaction().commit();
    }

    public void alterar(E entidade) {
        em.getTransaction().begin();
        em.merge(entidade);
        em.getTransaction().commit();
    }
}