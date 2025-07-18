package br.edu.ifpr.Doenca;

import br.edu.ifpr.Dao.Dao;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class DoencaDao extends Dao<Doenca>{


    public List<Doenca> todasDoencas(){
        String jpql = "SELECT d FROM Doenca d";
        return em.createQuery(jpql, Doenca.class).getResultList();
    }

    public Doenca buscaPorNome(String nome){
        String jpql = "SELECT d FROM Doenca d WHERE d.nome LIKE :nome";
        return em.createQuery(jpql, Doenca.class).setParameter("nome", nome).getSingleResult();
    }

}
