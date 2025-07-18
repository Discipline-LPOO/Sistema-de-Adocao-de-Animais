package br.edu.ifpr.apelido;

import br.edu.ifpr.dao.Dao;

import java.util.List;

public class ApelidoDao extends Dao<Apelido> {

    public static List<Apelido> todosApelidosDoencas(){
        String jpql = "SELECT DISTINCT a FROM Apelido a JOIN a.doencas";
        return em.createQuery(jpql, Apelido.class).getResultList();
    }

    public static List<Apelido> todosApelidosEspecies(){
        String jpql = "SELECT a FROM Apelido a JOIN a.especies";
        return em.createQuery(jpql, Apelido.class).getResultList();
    }

}
