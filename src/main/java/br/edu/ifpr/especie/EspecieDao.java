package br.edu.ifpr.especie;

import br.edu.ifpr.dao.Dao;
import br.edu.ifpr.doenca.Doenca;

import java.util.List;

public class EspecieDao extends Dao<Especie> {

    public List<Especie> todasEspecies(){
        String jpql = "SELECT d FROM Especie d";
        return em.createQuery(jpql, Especie.class).getResultList();
    }

    public Especie especiePorNome(String nome){
        String jpql = "SELECT e FROM Especie e WHERE e.nome = :nome";
        return em.createQuery(jpql, Especie.class).setParameter("nome", nome).getSingleResult();
    }


}
