package br.edu.ifpr.Doenca;

// Importações de biblioteca
import java.util.ArrayList;
import java.util.List;

// Importações de projeto
import br.edu.ifpr.NomeComum.NomeComum;

public class Doenca {
    private int id;
    private String nome;
    private List<NomeComum> apelidos;

    //Construtores
    public Doenca(int id, String nome, List<NomeComum> apelidos) {
        this.id = id;
        this.nome = nome;
        this.apelidos = apelidos;
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

    public List<NomeComum> getApelidos() {
        return apelidos;
    }

    public void setApelidos(List<NomeComum> apelidos) {
        this.apelidos = apelidos;
    }
}
