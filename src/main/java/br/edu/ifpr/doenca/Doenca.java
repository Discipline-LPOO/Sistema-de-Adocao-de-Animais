package br.edu.ifpr.doenca;

// Importações de biblioteca

import br.edu.ifpr.apelido.Apelido;
import br.edu.ifpr.vacina.Vacina;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "doencas")
@NoArgsConstructor
public class Doenca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doenca;

    @Column(length = 50, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "doencas")
    private List<Apelido> apelidos;

    @ManyToMany(mappedBy = "doencas")
    private List<Vacina> vacinas;

    //Construtores
    public Doenca(int id, String nome, List<Apelido> apelidos) {
        this.id_doenca = id;
        this.nome = nome;
        this.apelidos = apelidos;
    }

    //Getters e Setters
    public int getId() {
        return id_doenca;
    }

    public void setId(int id) {
        this.id_doenca = id;
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

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }
}
