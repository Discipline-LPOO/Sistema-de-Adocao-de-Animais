package br.edu.ifpr.Doenca;

import br.edu.ifpr.Dao.Dao;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

public class DoencaDao extends Dao<Doenca>{


    public List<Doenca> todasDoencas(){
        List<Doenca> doencas = new ArrayList<>();
        String sql = "SELECT nome from doenca";
        Query query = em.createNativeQuery(sql);
        doencas.addAll(query.getResultList());
        return doencas;
    }

}
