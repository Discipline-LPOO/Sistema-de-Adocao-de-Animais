package br.edu.ifpr.Vacina;

import br.edu.ifpr.Dao.Dao;

public class VacinaDao extends Dao<Vacina>{

    public Vacina buscarVacinaPorNomeFabricante(String nome, String fabricante){
        String jpql = "SELECT v FROM Vacina v WHERE v.nome LIKE :nome AND v.fabricante LIKE :fabricante";
        return em.createQuery(jpql, Vacina.class).setParameter("nome", nome).setParameter("fabricante", fabricante).getSingleResult();
    }
}
