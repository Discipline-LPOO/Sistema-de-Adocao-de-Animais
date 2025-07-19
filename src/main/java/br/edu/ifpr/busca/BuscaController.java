package br.edu.ifpr.busca;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class BuscaController implements Initializable {

    @FXML
    private TextField buscaField;

    @FXML
    private ChoiceBox<String> buscaChoice;

    private BuscaService buscaService = new BuscaService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buscaChoice.getItems().addAll(buscaService.itensChoicebox()); // retorna itens da choicebox para inserir nela
    }

    public void iniciarBusca(ActionEvent event) throws IOException {
        FXMLLoader loaderBusca = new FXMLLoader(getClass().getResource("Busca.fxml"));
        Parent rootBusca = loaderBusca.load();
        Stage stageBusca = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene sceneBusca = new Scene(rootBusca);
        stageBusca.setScene(sceneBusca);
        stageBusca.show();
    }

    public void buscar(ActionEvent event) throws IOException {
        List<Object> retornosBusca = buscaService.buscar(buscaField.getText(), buscaChoice.getValue());
        FXMLLoader loaderResultado = new FXMLLoader(getClass().getResource("Resultado.fxml"));
        Parent rootResultado = loaderResultado.load();
        Stage stageResultado = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene sceneResultado = new Scene(rootResultado);
        stageResultado.setScene(sceneResultado);
        stageResultado.show();
        /* TODO -> |Adicionar uma função que pega retornosBusca|
         * TODO -> |e adiciona os resultados na tela de resultado.|
         * TODO -> |Terá a lógica no service de modificar a tela com base no resultado.|
         */
    }


}