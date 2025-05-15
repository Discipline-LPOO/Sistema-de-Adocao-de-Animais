package br.edu.ifpr.Animal;

// Importações de biblioteca
import java.util.*;

// Importações do projeto
import br.edu.ifpr.Animal.Enum.Sexo;
import br.edu.ifpr.Especie.Especie;
import br.edu.ifpr.Vacina.Vacina;

public class Animal{
    private int id;
    private String nome;
    private int meses;
    private Especie especie;
    private Sexo sexo;
    private List<Vacina> vacinas;
    private Date data_acolhimento;
    private Date data_doacao;

    //Construtor
    public Animal(int id, String nome, int meses, Especie especie,
                  Sexo sexo, List<Vacina> vacinas,
                  Date data_acolhimento, Date data_doacao) {
        this.id = id;
        this.nome = nome;
        this.meses = meses;
        this.especie = especie;
        this.sexo = sexo;
        this.vacinas = vacinas;
        this.data_acolhimento = data_acolhimento;
        this.data_doacao = data_doacao;
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

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<Vacina> getVacinas() {
        return vacinas;
    }

    public void setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }

    public Date getData_acolhimento() {
        return data_acolhimento;
    }

    public void setData_acolhimento(Date data_acolhimento) {
        this.data_acolhimento = data_acolhimento;
    }

    public Date getData_doacao() {
        return data_doacao;
    }

    public void setData_doacao(Date data_doacao) {
        this.data_doacao = data_doacao;
    }
}


