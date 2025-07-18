package br.edu.ifpr.Animal;

import br.edu.ifpr.Dao.Dao;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AnimalDao extends Dao<Animal> {
    public static List<Animal> selectPorNome(String textoBusca) {
        TypedQuery<Animal> query = em.createQuery(
                "SELECT a FROM animais WHERE a.nome = :nome", Animal.class
        );
        query.setParameter("nome", textoBusca);
        return query.getResultList();
    }
// TODO -> Fix o uso de Date, não sei se está incorreto pesquisar uma string igual ao date no sql
    public static List<Animal> selectPorDataAcolhimento(String textoBusca) {
        TypedQuery<Animal> query = em.createQuery(
                "SELECT a FROM animais WHERE a.data_nasc = :data_nasc", Animal.class
        );
        query.setParameter("data_nasc", textoBusca);
        return query.getResultList();
    }
}
