package br.edu.ifpr.Vacina;

// Importações de biblioteca
import java.util.List;

// Importações do projeto
import br.edu.ifpr.Doenca.Doenca;

public class Vacina {
    private int id;
    private String nome;
    private String fabricante;
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