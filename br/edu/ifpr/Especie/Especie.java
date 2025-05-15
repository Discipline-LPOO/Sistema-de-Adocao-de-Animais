package br.edu.ifpr.Especie;

// Importações de biblioteca
import java.util.List;
import lombok.NoArgsConstructor;

// Importações do projeto
import br.edu.ifpr.Apelido.Apelido;

@NoArgsConstructor
public class Especie {
    private int id;
    private String nome;
    private List<Apelido> apelidos;

    //Construtor
    public Especie(int id, String nome, List<Apelido> apelidos) {
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

    public List<Apelido> getApelidos() {
        return apelidos;
    }

    public void setApelidos(List<Apelido> apelidos) {
        this.apelidos = apelidos;
    }
}