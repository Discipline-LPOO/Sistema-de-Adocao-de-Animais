package br.edu.ifpr.Cadastro;

// Importações do projeto
import br.edu.ifpr.Vacina.Vacina;
import br.edu.ifpr.Vacina.VacinaController;

// Importações de biblioteca
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;

public class CadastroVacinaController {
    private static int contador;

    @FXML
    private VBox doencasVBox;

    @FXML



    public List<Vacina> listaChoice(){
        List<Vacina> lista = VacinaController.todosNomesVacinas();
        ObservableList<String> opcoes = FXCollections.observableArrayList();
        return lista;
    }

    public void adicionarDoenca(){
        Pane pane = new Pane();
        Label label = new Label("Doença:");
        label.setLayoutX(Double.parseDouble("75.0"));;
        label.setLayoutY(Double.parseDouble("9.0"));

        ChoiceBox<String> choicebox = new ChoiceBox<String>();
        choicebox.setLayoutX(Double.parseDouble("118.0"));
        choicebox.setLayoutY(Double.parseDouble("31.0"));
        choicebox.setPrefHeight(Double.parseDouble("25.0"));
        choicebox.setPrefWidth(Double.parseDouble("302.0"));

        Button addDoenca = new Button("+" );
        addDoenca.setOnAction(event -> {});

        pane.getChildren().addAll(label, choicebox, addDoenca);
        doencasVBox.getChildren().add(pane);

        incrementarContador();
    }

    public void zerarContador(){
        contador = 0;
    }

    public void incrementarContador(){
        contador++;
    }
}
