package br.edu.ifpr.especie;

// Importações de biblioteca

import br.edu.ifpr.apelido.Apelido;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "especies")
@NoArgsConstructor
public class Especie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_especie;

    @Column(length = 50, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "especies")
    private List<Apelido> apelidos;

    //Construtor
    public Especie(int id, String nome, List<Apelido> apelidos) {
        this.id_especie = id;
        this.nome = nome;
        this.apelidos = apelidos;
    }

    //Getters e Setters
    public int getId() {
        return id_especie;
    }

    public void setId(int id) {
        this.id_especie = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Apelido> getApelidos() {
        return apelidos;
    }

    public void setApelidos(List<Apelido> apelidos) {
        this.apelidos = apelidos;
    }
}