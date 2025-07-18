package br.edu.ifpr.documentoResidencia;

// Importação de bibliotecas
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "docs_identidade")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DocumentoResidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name= "caminho_arquivo", length = 100, nullable = false)
    private String arquivo;
}
