package br.edu.ifpr.animal;

// Importações de biblioteca

import br.edu.ifpr.especie.Especie;
import br.edu.ifpr.vacina.Vacina;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "animais")
@NoArgsConstructor
public class Animal{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name= "nome", length = 45, nullable = false)
    private String nome;

    @Column(name = "data_nasc", nullable = false)
    private Date data_nasc;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_especie", nullable = false)
    private Especie especie;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    private Sexo sexo;

    @Column(name = "castracao", nullable = false)
    private boolean castracao;

    @ManyToMany()
    @JoinTable(name = "animais_vacinas",
            joinColumns = @JoinColumn(name = "id_animal"),
            inverseJoinColumns = @JoinColumn(name = "id_vacina")
    )
    private List<Vacina> vacinas;

    @Column(name = "data_acolhimento", nullable = false)
    private Date data_acolhimento;


    //Construtor
    public Animal(int id, String nome, Date data_nasc, Especie especie,
                  Sexo sexo, List<Vacina> vacinas,
                  Date data_acolhimento) {
        this.id = id;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.especie = especie;
        this.sexo = sexo;
        this.vacinas = vacinas;
        this.data_acolhimento = data_acolhimento;
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

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nas) {
        this.data_nasc = data_nas;
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

    public boolean getCastracao() {
        return castracao;
    }

    public void setCastracao(boolean castracao){
        this.castracao = castracao;
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
}


