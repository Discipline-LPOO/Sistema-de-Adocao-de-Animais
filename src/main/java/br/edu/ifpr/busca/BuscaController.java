package br.edu.ifpr.busca;


import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;



public class BuscaController {

    @FXML
    private TextField buscaField;

    @FXML
    private ChoiceBox<String> buscaChoice;

    private String textoBusca = buscaField.getText();
    private String itemSelecionado = buscaChoice.getValue();

    private BuscaService buscaService = new BuscaService();


    public void buscar(String textoBusca, String getItemSelecionado){
        buscaService.buscar(textoBusca, getItemSelecionado);
    }

    @FXML
    public void criarChoiceBox() {

    }

}