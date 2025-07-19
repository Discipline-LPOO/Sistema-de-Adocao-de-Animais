package br.edu.ifpr.apelido;

import br.edu.ifpr.dao.Dao;

import java.util.List;

public class ApelidoDao extends Dao<Apelido> {

    public List<Apelido> todosApelidosDoencas(){
        String jpql = "SELECT DISTINCT a FROM Apelido a JOIN a.doencas";
        return em.createQuery(jpql, Apelido.class).getResultList();
    }

    public List<Apelido> todosApelidosEspecies(){
        String jpql = "SELECT a FROM Apelido a JOIN a.especies";
        return em.createQuery(jpql, Apelido.class).getResultList();
    }

    public List<Apelido> todosApelidos(){
        String jpql =  "SELECT DISTINCT a FROM Apelido a";
        return em.createQuery(jpql, Apelido.class).getResultList();
    }

    public Apelido buscarPorNome(String nome){
        String jpql = "SELECT a FROM Apelido a WHERE nome LIKE :nome";
        return em.createQuery(jpql, Apelido.class).getSingleResult();
    }

}
