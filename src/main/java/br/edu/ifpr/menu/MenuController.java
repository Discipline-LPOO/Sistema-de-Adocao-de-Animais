package br.edu.ifpr.menu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private Label buscaLabel, adocaoLabel, animalLabel, adotanteLabel, vacinaLabel, doencaLabel;

    @FXML
    public void handleMenuClick(MouseEvent event) {
        System.out.println("Clique capturado!");
        Label clickedLabel = (Label) event.getSource();
        String labelId = clickedLabel.getId();

        String fxmlPath = null;

        switch (labelId) {
            case "buscaLabel":
                fxmlPath = "/fxml/Busca.fxml";
                break;
            case "adocaoLabel":
                fxmlPath = "/fxml/NovaAdocao.fxml";
                break;
            case "animalLabel":
                fxmlPath = "/fxml/CadastroAnimal.fxml";
                break;
            case "adotanteLabel":
                fxmlPath = "/fxml/CadastroAdotante.fxml";
                break;
            case "vacinaLabel":
                fxmlPath = "/fxml/CadastroVacina.fxml";
                break;
            case "doencaLabel":
                fxmlPath = "/fxml/CadastroDoenca.fxml";
                break;
            case "especieLabel":
                fxmlPath = "/fxml/CadastroEspecie.fxml";
                break;
            default:
                System.out.println("Nenhuma ação definida");
        }

        if (fxmlPath != null) {
            abrirTela(fxmlPath);
        }
    }

    private void abrirTela(String fxmlPath) {
        try {
            Parent novaTela = FXMLLoader.load(getClass().getResource(fxmlPath));
            Stage stage = (Stage) buscaLabel.getScene().getWindow();
            stage.getScene().setRoot(novaTela);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void menu() {
        abrirTela("/fxml/menu.fxml");
    }

}
