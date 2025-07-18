package br.edu.ifpr.adocao;

// Importações do projeto

import br.edu.ifpr.adotante.Adotante;
import br.edu.ifpr.animal.Animal;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "adocoes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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