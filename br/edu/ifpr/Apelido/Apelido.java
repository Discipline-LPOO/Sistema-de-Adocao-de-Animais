package br.edu.ifpr.Apelido;

import jakarta.persistence.*;

public class Apelido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany()
    private String nome;

    //Construtor
    public Apelido(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
    