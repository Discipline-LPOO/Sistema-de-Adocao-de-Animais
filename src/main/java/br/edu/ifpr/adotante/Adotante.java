package br.edu.ifpr.adotante;

// Importações do projeto

import br.edu.ifpr.documentoIdentidade.DocumentoIdentidade;
import br.edu.ifpr.documentoResidencia.DocumentoResidencia;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "adotantes")
@NoArgsConstructor
public class Adotante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_adotante;

    @Column(name = "nome", length = 45, nullable = false)
    private String nome;

    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;

    @OneToOne()
    @JoinColumn(name = "id_doc_identidade", referencedColumnName = "id_doc_identidade")
    private DocumentoIdentidade docID;

    @OneToOne()
    @JoinColumn(name = "id_doc_residencia")
    private DocumentoResidencia comprovanteEnd;

    @Column(name = "telefone", length = 11, nullable = false)
    private String telefone;

    //Construtor
    public Adotante(int id, String nome, String cpf, DocumentoIdentidade docID, String endereco, DocumentoResidencia
        comprovanteEnd, String telefone) {
        this.id_adotante = id;
        this.nome = nome;
        this.cpf = cpf;
        this.docID = docID;
        this.comprovanteEnd = comprovanteEnd;
        this.telefone = telefone;
    }

    //Getters e Setters
    public int getId() {
        return id_adotante;
    }

    public void setId(int id) {
        this.id_adotante = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public DocumentoIdentidade getDocID() {
        return docID;
    }

    public void setDocID(DocumentoIdentidade docID) {
        this.docID = docID;
    }

    public DocumentoResidencia getComprovanteEnd() {
        return comprovanteEnd;
    }

    public void setComprovanteEnd(DocumentoResidencia comprovanteEnd) {
        this.comprovanteEnd = comprovanteEnd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}