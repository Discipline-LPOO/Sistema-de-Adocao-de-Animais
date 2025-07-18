package br.edu.ifpr.vacina;

// Importações de biblioteca

import br.edu.ifpr.doenca.Doenca;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "vacinas")
@NoArgsConstructor
public class Vacina {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 45, nullable = false)
    private String nome;

    @Column(length = 45, nullable = false)
    private String fabricante;

    @ManyToMany
    @JoinTable(name = "vacinas_doencas",
            joinColumns = @JoinColumn(name = "id_vacina"),
            inverseJoinColumns = @JoinColumn(name = "id_doenca")
    )
    private List<Doenca> doencas;

    //Construtores
    public Vacina(int id, String nome, String fabricante, List<Doenca> Doenca) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.doencas = doencas;
}
    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }

    public List<Doenca> getDoencas() {
        return doencas;
    }

    public void setDoencas(List < Doenca > doencas) {
        this.doencas = doencas;
    }
}