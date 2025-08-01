package br.edu.ifpr.vacina;

// Importações do projeto

import br.edu.ifpr.doenca.Doenca;
import br.edu.ifpr.doenca.DoencaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.util.*;

public class VacinaController implements Initializable {
    private static int contador = 1;

    private VacinaService service = new VacinaService();

    @FXML
    private TextField nomeVacina;

    @FXML
    private TextField cadastroFabricante;

    @FXML
    private VBox cadastroContent;

    @FXML
    private ChoiceBox doencaChoice1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        doencaChoice1.setItems(listaDoencas());
    }

    public ObservableList<String> listaDoencas(){
        List<String> listaDoencas = DoencaService.todasDoencas();
        ObservableList<String> observableList = FXCollections.observableArrayList(listaDoencas);
        return observableList;
    }

    public void adicionarDoenca(){
        contador++;

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
        choicebox.setId(("doencaChoice" + Integer.toString(contador)));
        choicebox.setItems(listaDoencas());

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

    public void cadastrarVacina(ActionEvent event){
        ObservableList<Node> children = cadastroContent.getChildren();
        List<Doenca> doencas = new ArrayList<>();

        // Loop para capturar objetos de todos os campos gerados
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            String id = node.getId();

            if(id.contains("doenca")){
                String choiceId = "#doencaChoice" + id.substring(id.length()-1);
                ChoiceBox<String> choicebox = ((ChoiceBox<String>) node.lookup(choiceId));
                String text = choicebox.getValue();

                if (text != null) {
                    doencas.add(DoencaService.doencaPorNome(text));
                }
            }
        }

        // Elimina duplicações
        Set<Doenca> set = new HashSet<>(doencas);
        doencas = new ArrayList<>(set);

        String nome = nomeVacina.getText();
        String fabricante = cadastroFabricante.getText();

        if (service.existe(nome, fabricante)) {
            Vacina vacina = service.buscarPorNome(nome, fabricante);
            List<Doenca> doencasCadastradas = vacina.getDoencas();
            doencasCadastradas.addAll(doencas);
            vacina.setDoencas(doencasCadastradas);
            System.out.println(doencasCadastradas);
            service.atualizarVacina(vacina);
        }
        else {
            Vacina vacina = new Vacina();
            vacina.setNome(nome);
            vacina.setFabricante(fabricante);
            vacina.setDoencas(doencas);
            service.adicionarVacina(vacina);
        }

        reiniciarContador();
        voltarInicio(event);
    }

}