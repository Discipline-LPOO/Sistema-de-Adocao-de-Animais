package br.edu.ifpr.vacina;

// Importações do projeto

import br.edu.ifpr.doenca.Doenca;
import br.edu.ifpr.doenca.DoencaService;
import br.edu.ifpr.menu.MenuController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VacinaController {
    private static int contador = 1;

    @FXML
    private TextField nomeVacina;

    @FXML
    private TextField cadastroFabricante;

    @FXML
    private VBox cadastroContent;


    @FXML
    private ChoiceBox<String> doencaChoice;

    public VacinaController(){
        doencaChoice.setItems((ObservableList) listaDoencas());
    }
    public List<String> listaDoencas(){
        return DoencaService.todasDoencas();
    }

    public void adicionarDoenca(){
        incrementarContador();

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

        Button addDoenca = new Button("+" );
        addDoenca.setLayoutX(Double.parseDouble("540.0"));
        addDoenca.setLayoutY(Double.parseDouble("30.0"));
        addDoenca.setOnAction(event -> adicionarDoenca());

        pane.getChildren().addAll(label, choicebox, addDoenca);
        cadastroContent.getChildren().add(pane);
    }

    public void reiniciarContador(){
        contador = 1;
    }

    public void incrementarContador(){
        contador++;
    }

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

    public void cadastrarVacina(){
        ObservableList<Node> children = cadastroContent.getChildren();
        List<Doenca> doencas = new ArrayList<>();

        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            String id = node.getId();

            if(id.contains("doenca") && node instanceof ChoiceBox){
                String text = ((ChoiceBox<String>) node).getValue();
                doencas.add(DoencaService.doencaPorNome(text));
            }
        }

        String nome = nomeVacina.getText();
        String fabricante = cadastroFabricante.getText();

        if (!VacinaService.existe(nome, fabricante)) {
            Vacina vacina = new Vacina();
            vacina.setNome(nome);
            vacina.setFabricante(fabricante);
            vacina.setDoencas(doencas);

            VacinaService.adicionarVacina(vacina);
        }

        reiniciarContador();
    }

}