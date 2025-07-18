package br.edu.ifpr.Cadastro;

// Importações do projeto
import br.edu.ifpr.Vacina.Vacina;
import br.edu.ifpr.Vacina.VacinaController;
import br.edu.ifpr.Doenca.DoencaService;


// Importações de biblioteca
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class CadastroVacinaController {
    private static int contador;

    @FXML
    private TextField nomeVacina;

    @FXML
    private TextField cadastroFabricante;

    @FXML
    private VBox cadastroContent;


    public List<String> listaDoencas(){
        return DoencaService.todasDoencas();
    }

    public void adicionarDoenca(){
        Pane pane = new Pane();
        pane.setId(("doencaPane" + Integer.toString(contador)));
        pane.setPrefHeight(Double.parseDouble("70.0"));
        pane.setPrefWidth(Double.parseDouble("652.0"));

        Label label = new Label("Doença:");
        label.setLayoutX(Double.parseDouble("75.0"));;
        label.setLayoutY(Double.parseDouble("9.0"));

        ChoiceBox<String> choicebox = new ChoiceBox<String>();
        choicebox.setLayoutX(Double.parseDouble("118.0"));
        choicebox.setLayoutY(Double.parseDouble("31.0"));
        choicebox.setPrefHeight(Double.parseDouble("25.0"));
        choicebox.setPrefWidth(Double.parseDouble("302.0"));
        choicebox.getItems().addAll(listaDoencas());

        Button addDoenca = new Button("+" );
        addDoenca.setOnAction(event -> {});

        pane.getChildren().addAll(label, choicebox, addDoenca);
        cadastroContent.getChildren().add(pane);

        incrementarContador();
    }

    public void zerarContador(){
        contador = 0;
    }

    public void incrementarContador(){
        contador++;
    }

    public void cadastrarVacina(){

    }
}
