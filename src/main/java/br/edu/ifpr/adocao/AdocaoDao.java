package br.edu.ifpr.adocao;

import br.edu.ifpr.dao.Dao;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AdocaoDao extends Dao<Adocao>{
    public static List<Adocao> selectPorDataAdocao(String textoBusca) {
        TypedQuery<Adocao> query = em.createQuery(
                "SELECT a FROM adocoes WHERE a.data_adocao = :data_adocao", Adocao.class
        );
        query.setParameter("data_adocao", textoBusca);
        return query.getResultList();
    }

    public static List<Adocao> selectPorNomeAdotante(String textoBusca) {
        TypedQuery<Adocao> query = em.createQuery(
                "SELECT a FROM adocoes WHERE a.adotante.nome = :nome", Adocao.class
        );
        query.setParameter("nome", textoBusca);
        return query.getResultList();
    }

    public static List<Adocao> selectPorNomeAnimal(String textoBusca) {
        TypedQuery<Adocao> query = em.createQuery(
                "SELECT a FROM adocoes WHERE a.animal.nome = :nome", Adocao.class
        );
        query.setParameter("nome", textoBusca);
        return query.getResultList();
    }

    public static List<Adocao> selectAnimaisAdotados() {
        TypedQuery<Adocao> query = em.createQuery(
                "SELECT a FROM adocoes ad WHERE ad.id_animal = ", Adocao.class
        );
        return query.getResultList();
}
