package br.edu.ifpr.animal;

import br.edu.ifpr.dao.Dao;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AnimalDao extends Dao<Animal> {

    public List<Animal> selectPorNome(String textoBusca) {
        TypedQuery<Animal> query = em.createQuery(
                "SELECT a FROM animais WHERE a.nome = :nome", Animal.class
        );
        query.setParameter("nome", textoBusca);
        return query.getResultList();
    }
// TODO -> Fix o uso de Date, não sei se está incorreto pesquisar uma string igual ao date no sql
    public List<Animal> selectPorDataAcolhimento(String textoBusca) {
        TypedQuery<Animal> query = em.createQuery(
                "SELECT a FROM animais WHERE a.data_nasc = :data_nasc", Animal.class
        );
        query.setParameter("data_nasc", textoBusca);
        return query.getResultList();
    }

    public List<Animal> selectPorId(int id) {
        String jpql = "SELECT a FROM Animal a WHERE id = :id";
        return em.createQuery(jpql, Animal.class).getResultList();
    }

    public List<Animal> todosAnimais(){
        String jpql = "SELECT a FROM animais";
        return em.createQuery(jpql, Animal.class).getResultList();
    }

}
