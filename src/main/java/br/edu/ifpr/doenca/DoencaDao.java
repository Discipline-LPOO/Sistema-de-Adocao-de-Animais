package br.edu.ifpr.doenca;

import br.edu.ifpr.dao.Dao;

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
