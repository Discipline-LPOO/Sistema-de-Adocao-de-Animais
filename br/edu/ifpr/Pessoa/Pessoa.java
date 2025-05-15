package br.edu.ifpr.Pessoa;

// Importações do projeto
import br.edu.ifpr.DocumentoIdentidade.DocumentoIdentidade;

public class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private DocumentoIdentidade docID;
    private String endereco;
    private DocumentoIdentidade comprovanteEnd;
    private String telefone;

    //Construtor
    public Pessoa(int id, String nome, String cpf, DocumentoIdentidade docID, String endereco, DocumentoIdentidade comprovanteEnd, String telefone) {
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

    public DocumentoIdentidade getComprovanteEnd() {
        return comprovanteEnd;
    }

    public void setComprovanteEnd(DocumentoIdentidade comprovanteEnd) {
        this.comprovanteEnd = comprovanteEnd;
    }
}