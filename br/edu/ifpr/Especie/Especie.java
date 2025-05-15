package br.edu.ifpr.Especie;

// Importações de biblioteca
import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;

// Importações do projeto
import br.edu.ifpr.NomeComum.NomeComum;

@NoArgsConstructor
public class Especie {
    private int id;
    private String nome;
    private List<NomeComum> apelidos;

    //Construtor
    public Especie(int id, String nome, List<NomeComum> apelidos) {
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