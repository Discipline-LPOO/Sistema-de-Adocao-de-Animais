package br.edu.ifpr.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao<Object> {

    private static Dao instance;
    protected static EntityManager em;

    // Construtor de classe
    protected Dao() {
        em = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("adocao_de_animais");
        if (em == null) {
            em = getEntityManager();
        }
        return em;
    }

    public static Dao getInstance() {
        // Tratamento de exceção para quando o construtor não foi rodado
        // antes da chamada desse get, chama o construtor
        if (instance == null) {
            instance = new Dao();
        }
        return instance;
    }

    public void salvar(Object object){
        try{
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        }
        catch(Exception exception){
            exception.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void atualizar(Object object){
        try{
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        }
        catch(Exception exception){
            exception.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void excluir(Object object){
        try{
            em.getTransaction().begin();
            em.remove(object);
            em.getTransaction().commit();
        }
        catch(Exception exception){
            exception.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
