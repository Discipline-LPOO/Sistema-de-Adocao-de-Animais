package br.edu.ifpr.especie;

import br.edu.ifpr.apelido.Apelido;
import br.edu.ifpr.apelido.ApelidoService;
import br.edu.ifpr.doenca.Doenca;
import br.edu.ifpr.doenca.DoencaService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EspecieController {
    private int contador = 1;

    private EspecieService service = new EspecieService();

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

    public void reiniciarContador(){
        contador = 1;
    }

    public void salvarEspecie(ActionEvent event){
        ObservableList<Node> children = cadastroContent.getChildren();
        List<Apelido> apelidos = new ArrayList<>();
        List<String> todosApelidos = ApelidoService.todosApelidos();

        // Loop para capturar objetos de todos os campos gerados
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            String id = node.getId();

            if (id.contains("apelido")) {
                String choiceId = "#apelidoField" + id.substring(id.length() - 1);
                TextField textField = ((TextField) node.lookup(choiceId));
                String text = textField.getText();

                if (text != null && todosApelidos.contains(text)) {
                    apelidos.add(ApelidoService.buscarPorNome(text));
                }
                else if(text != null && service.validateTextField(text)){
                    ApelidoService.adicionarApelido(text);
                    todosApelidos =  ApelidoService.todosApelidos();
                    apelidos.add(ApelidoService.buscarPorNome(text));
                }
            }
        }

        Set<Apelido> set = new HashSet<>(apelidos);
        apelidos = new ArrayList<>(set);

        String nome = nomeField.getText();

        if (service.existe(nome) && !apelidos.isEmpty()) {
            Especie especie = service.especiePorNome(nome);
            especie.setApelidos(apelidos);
            service.atualizarEspecie(especie);
        }
        else{
            Especie especie = new Especie();
            especie.setNome(nome);
            especie.setApelidos(apelidos);
            service.adicionarEspecie(especie);
        }

        voltarInicio(event);

    }

    public void voltarInicio(ActionEvent event){
        try {
            reiniciarContador();
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

}
