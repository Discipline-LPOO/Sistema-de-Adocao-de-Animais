package br.edu.ifpr.doenca;

import br.edu.ifpr.apelido.Apelido;
import br.edu.ifpr.apelido.ApelidoService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoencaController {
    private static int contador = 1;

    private DoencaService service = new DoencaService();

    @FXML
    private VBox cadastroContent;

    @FXML
    private TextField nomeField;

    public void adicionarApelido(){
        contador++;

        Pane pane = new Pane();
        pane.setId(("apelidoPane" + Integer.toString(contador)));
        pane.setPrefHeight(Double.parseDouble("70.0"));
        pane.setPrefWidth(Double.parseDouble("652.0"));

        Label label = new Label("Nome comum:");
        label.setLayoutX(Double.parseDouble("75.0"));;
        label.setLayoutY(Double.parseDouble("20.0"));

        TextField textfield = new TextField();
        textfield.setLayoutX(Double.parseDouble("96.0"));
        textfield.setLayoutY(Double.parseDouble("39.0"));
        textfield.setId(("apelidoField" + Integer.toString(contador)));

        Button addApelido = new Button("+" );
        addApelido.setLayoutX(Double.parseDouble("538.0"));
        addApelido.setLayoutY(Double.parseDouble("30.0"));
        addApelido.setOnAction((e) -> adicionarApelido());

        pane.getChildren().addAll(label, textfield, addApelido);
        cadastroContent.getChildren().add(pane);
    }

    public void salvarDoenca(){
        ObservableList<Node> children = cadastroContent.getChildren();
        List<Apelido> apelidos = new ArrayList<>();
        List<String> todosApelidos = ApelidoService.();

        // Loop para capturar objetos de todos os campos gerados
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            String id = node.getId();

            if(id.contains("apelido")){
                String choiceId = "#apelidoField" + id.substring(id.length()-1);
                TextField textField= ((TextField) node.lookup(choiceId));
                String text = textField.getText();

                if (text != null) {
                    if() {
                        apelidos.add(ApelidoService.buscarPorNome(text));
                    }
                }
            }

            Set<Apelido> set = new HashSet<>(apelidos);
            apelidos = new ArrayList<>(set);

            String nome = nomeField.getText();

            if (service.existe(nome)){
                Doenca doenca = service.doencaPorNome(nome);

            }
            else{
                Doenca doenca = new Doenca();
                doenca.setNome(nome);
                doenca.setApelidos(apelidos);
            }


        }
    }
}
