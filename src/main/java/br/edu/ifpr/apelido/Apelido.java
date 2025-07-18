package br.edu.ifpr.apelido;

// Importações do projeto

import br.edu.ifpr.doenca.Doenca;
import br.edu.ifpr.especie.Especie;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "apelidos")
@NoArgsConstructor
public class Apelido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 50, nullable = false)
    private String nome;

    @ManyToMany()
    @JoinTable(name = "apelidos_doencas",
            joinColumns = @JoinColumn(name = "id_apelido"),
            inverseJoinColumns = @JoinColumn(name = "id_doenca")
    )
    private List<Doenca> doencas;

    @ManyToMany()
    @JoinTable(name = "apelidos_especies",
            joinColumns = @JoinColumn(name = "id_apelido"),
            inverseJoinColumns = @JoinColumn(name = "id_especie")
    )
    private List<Especie> especies;

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

    public List<Doenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(List<Doenca> doencas) {
        this.doencas = doencas;
    }

    public List<Especie> getEspecies() {
        return especies;
    }

    public void setEspecies(List<Especie> especies) {
        this.especies = especies;
    }
}
    