package br.edu.ifpr.DocumentoIdentidade;

// Importações de biblioteca
import java.sql.Blob;

// Importações de projeto


public class DocumentoIdentidade {
    private int id;
    private TipoDocumento tipo;
    private String numero;

    //Construtor
    public DocumentoIdentidade(int id, TipoDocumento tipo, String numero, Blob arquivo) {
        this.id = id;
        this.tipo = tipo;
        this.numero = numero;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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