package br.edu.ifpr.Busca;


import com.sun.javafx.fxml.FXMLLoaderHelper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ChoiceBox;

import javafx.scene.control.TextField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class BuscaController {

    @FXML
    private TextField buscaField;

    @FXML
    private ChoiceBox<String> buscaChoice;

    @Setter
    @Getter
    private String textoBusca = buscaField.getText();
    @Setter
    @Getter
    private String itemSelecionado = buscaChoice.getValue();

    @Setter
    private BuscaEResultadoService buscaEResultadoService;
    // TODO -> Lembrar de instanciar isso na Main

    // TODO -> Adicionar função ao botão de buscar
    public void buscar(String textoBusca, String getItemSelecionado){
        buscaEResultadoService.buscar(textoBusca, getItemSelecionado);
    }

    public void abrirResultado(List<?> listaResultados){
        // Abre a outra tela, passando o resultado
    }

    @FXML
    public void criarChoiceBox() {

    }

}