package br.edu.ifpr.vacina;

import br.edu.ifpr.dao.Dao;

import java.util.List;

public class VacinaDao extends Dao<Vacina>{

    public List<Vacina> todasVacinas(){
        String jpql = "select v from Vacina v";
        return em.createQuery(jpql, Vacina.class).getResultList();
    }

    public List<Vacina> todasVacinasPorNome(String nome){
        String jpql = "select v from Vacina v where v.nome = :nome";
        return em.createQuery(jpql, Vacina.class).setParameter("nome", nome).getResultList();
    }

    public Vacina buscarVacinaPorNomeFabricante(String nome, String fabricante){
        String jpql = "SELECT v FROM Vacina v WHERE v.nome LIKE :nome AND v.fabricante LIKE :fabricante";
        return em.createQuery(jpql, Vacina.class).setParameter("nome", nome).setParameter("fabricante", fabricante).getSingleResult();
    }
}
