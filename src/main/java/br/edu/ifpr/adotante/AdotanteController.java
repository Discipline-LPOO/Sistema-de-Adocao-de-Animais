package br.edu.ifpr.adotante;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class AdotanteController {

    @FXML
    private TextField cadastroNomeField;

    @FXML
    private TextField cpfField;

    @FXML
    private TextField telefoneField;

    @FXML
    private TextField enderecoField;

    public void voltarInicio(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Menu.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void cadastrarAdotante (ActionEvent event){
        String nome = cadastroNomeField.getText();
        String cpf = cpfField.getText();
        String telefone = telefoneField.getText();
        String endereco = enderecoField.getText();
        // TODO -> Add documentos
        // TODO -> Add documentos como parâmetros
        AdotanteService.cadastrarAdotante(nome, cpf, telefone, endereco);
        voltarInicio(event);
    }
}
