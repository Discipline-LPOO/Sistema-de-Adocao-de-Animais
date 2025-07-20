package br.edu.ifpr.documentoIdentidade;

// Importações de biblioteca
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

// Importações de projeto

@Entity
@Table(name="docs_identidade")
@NoArgsConstructor
public class DocumentoIdentidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_doc_identidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo", nullable = false)
    private TipoDocumento tipo;

    @Column(name = "numero", length = 11, nullable = false)
    private String numero;

    //Construtor
    public DocumentoIdentidade(int id, TipoDocumento tipo, String numero) {
        this.id_doc_identidade = id;
        this.tipo = tipo;
        this.numero = numero;
    }

    //Getters e Setters
    public int getId() {
        return id_doc_identidade;
    }

    public void setId(int id) {
        this.id_doc_identidade = id;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public String getnumero() {
        return numero;
    }

    public void setnumero(String numero) {
        this.numero = numero;
    }
}