package br.edu.ifpr.adotante;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class AdotanteController {

    @FXML
    private TextField cadastroNomeField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField enderecoField;

    private String nome = cadastroNomeField.getText();
    private String cpf = cpfField.getText();
    private String telefone = telefoneField.getText();
    private String endereco = enderecoField.getText();
    // TODO -> Add documentos
    private AdotanteService adotanteService = new AdotanteService();
    // TODO -> Add documentos como parâmetros
    public void cadastrarAdotante(String nome, String cpf, String telefone, String endereco) {
        adotanteService.cadastrarAdotante(nome, cpf, telefone, endereco);
    }
}
