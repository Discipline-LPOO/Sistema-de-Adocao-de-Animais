package br.edu.ifpr.Apelido;

import br.edu.ifpr.Dao.Dao;
import jakarta.persistence.Query;

import java.util.ArrayList;
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
