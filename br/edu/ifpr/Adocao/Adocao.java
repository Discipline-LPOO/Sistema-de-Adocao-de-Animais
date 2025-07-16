package br.edu.ifpr.Adocao;

// Importações do projeto
import br.edu.ifpr.Adotante.Adotante;
import br.edu.ifpr.Animal.Animal;

// Importações de bibliotecas
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "adocoes")
public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "data_adocao", nullable = false)
    private Date data;

    @OneToOne()
    @JoinColumn(name = "id_adotante", nullable = false)
    private Adotante adotante;

    @OneToOne()
    @JoinColumn(name = "id_animal", nullable = false)
    private Animal animal;
}