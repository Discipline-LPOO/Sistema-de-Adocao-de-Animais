package br.edu.ifpr.Adotante;

import br.edu.ifpr.Dao.Dao;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AdotanteDao extends Dao<Adotante> {
/*
Precisa ser estático, ainda vou procurar o pq, eu n sei kkkkkkkkkk
selectPorNome retorna uma lista de objetos encontrados (List <Adotante>)
Recebe o texto de lá da Busca View (textoBusca)
Primeiramente cria "query", uma variável do tipo "TypedQuery" (coisa do jakarta), mas define o que ela vai retornar
Cria com o entity manager (em) a query em JPQL (SQL do Java)
Transcrito fica:
SELECT o objeto "a" do tipo "Adotante" onde o nome for igual a ":nome"
Basicamente, oq o model faz, é linkar as linhas das tabelas SQL para objetos em java
"query.setParameter("name", textoBusca);" faz com que ":nome" seja o parâmetro que eu passei
retorna a lista de adotantes (objetos)

Deixei o nome da tabela igual ao do model pra n dar conflito
*/
    public static List<Adotante> selectPorNome(String textoBusca) {
        TypedQuery<Adotante> query = em.createQuery(
                "SELECT a FROM adotantes WHERE a.nome = :nome", Adotante.class
        );
        query.setParameter("nome", textoBusca);
        return query.getResultList();
    }

    public static List<Adotante> selectPorCPF(String textoBusca) {
        TypedQuery<Adotante> query = em.createQuery(
                "SELECT a FROM adotantes WHERE a.cpf = :cpf", Adotante.class
        );
        query.setParameter("cpf", textoBusca);
        return query.getResultList();
    }
}
