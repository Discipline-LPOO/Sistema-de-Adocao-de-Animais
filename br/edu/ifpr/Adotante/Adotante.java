package br.edu.ifpr.Adotante;

// Importações do projeto
import br.edu.ifpr.DocumentoIdentidade.DocumentoIdentidade;
import br.edu.ifpr.DocumentoResidencia.DocumentoResidencia;

public class Adotante {
    private int id;
    private String nome;
    private String cpf;
    private DocumentoIdentidade docID;
    private String endereco;
    private DocumentoResidencia comprovanteEnd;
    private String telefone;

    //Construtor
    public Adotante(int id, String nome, String cpf, DocumentoIdentidade docID, String endereco, DocumentoResidencia
        comprovanteEnd, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.docID = docID;
        this.endereco = endereco;
        this.comprovanteEnd = comprovanteEnd;
        this.telefone = telefone;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public DocumentoResidencia getComprovanteEnd() {
        return comprovanteEnd;
    }

    public void setComprovanteEnd(DocumentoResidencia comprovanteEnd) {
        this.comprovanteEnd = comprovanteEnd;
    }
}