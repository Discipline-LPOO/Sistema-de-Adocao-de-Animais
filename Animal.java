import java.util.*;

public class Animal {
    private Long id;
    private String nome;
    private int meses;
    private Especie especie;
    private Sexo sexo;
    private List<Vacina> vacinas; 
    private Date data_acolhimento;
    private Date data_doacao;
}

    //Construtor
    public Animal (Long id, String nome, int meses, Especie especie, Sexo sexo, List<Vacina> vacinas, Date data_acolhimento, Date data_doacao) {
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
    public Long getId() {
        return id;
    }
    public Long setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public String setNome(String nome) {
        this.nome = nome;
    }
    public int getMeses() {
        return meses;
    }
    public int setMeses(int meses) {
        this.meses = meses;
    }
    public Especie getEspecie() {
        return especie;
    }
    public Especie setEspecie(Especie especie) {
        this.especie = especie;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public Sexo setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
    public List<Vacina> getVacinas() {
        return vacinas;
    }
    public List<Vacina> setVacinas(List<Vacina> vacinas) {
        this.vacinas = vacinas;
    }
    public Date getData_acolhimento() {
        return data_acolhimento;
    }
    public Date setData_acolhimento(Date data_acolhimento) {
        this.data_acolhimento = data_acolhimento;
    }
    public Date getData_doacao() {
        return data_doacao;
    }
    public Date setData_doacao(Date data_doacao) {
        this.data_doacao = data_doacao;
    }


