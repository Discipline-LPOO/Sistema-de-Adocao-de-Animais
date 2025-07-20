package br.edu.ifpr.animal;

import br.edu.ifpr.especie.Especie;
import br.edu.ifpr.especie.EspecieService;
import br.edu.ifpr.vacina.Vacina;
import br.edu.ifpr.vacina.VacinaService;
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

public class AnimalController implements Initializable {
    private int contador = 1;

    private static AnimalService service = new AnimalService();

    @FXML
    private TextField nomeField;

    @FXML
    private TextField nascField;

    @FXML
    private TextField acolhimentoField;

    @FXML
    private ChoiceBox<String> especieChoice;

    @FXML
    private ChoiceBox<Sexo> sexoChoice;

    @FXML
    private ChoiceBox<String> vacinaChoice1;

    @FXML
    private VBox cadastroContent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        vacinaChoice1.setItems(listaVacinas());

        ObservableList<String> especies = FXCollections.observableArrayList(EspecieService.todasEspecies());
        especieChoice.setItems(especies);

        ObservableList<Sexo> listaSexos = FXCollections.observableArrayList(Sexo.values());
        sexoChoice.setItems(listaSexos);
    }

    public ObservableList<String> listaVacinas(){
        List<String> vacinas = VacinaService.todasVacinas();
        ObservableList<String> observableList = FXCollections.observableArrayList(vacinas);
        return observableList;
    }

    public ObservableList<String> listaFabricante(String vacina){
        if(vacina != null){
            List<String> fabricantes = VacinaService.fabricantePorNomeVacina(vacina);
            ObservableList<String> observableList = FXCollections.observableArrayList(fabricantes);
            return observableList;
        }
        return null;
    }

    public void definirListaFabricante(ActionEvent event){
        ChoiceBox<String> vacina = (ChoiceBox<String>) event.getSource();
        String id = vacina.getId();
        id = ("#fabricanteChoice" + id.substring(id.length()-1));

        Node parent = (Node) vacina.getParent();
        ChoiceBox<String> fabricante = ((ChoiceBox<String>)parent.lookup(id));

        fabricante.setItems(listaFabricante(vacina.getValue()));
    }

    public void adicionarVacina(){
        contador++;

        Pane pane = new Pane();
        pane.setId(("vacinaPane" + Integer.toString(contador)));
        pane.setPrefHeight(Double.parseDouble("209.0"));
        pane.setPrefWidth(Double.parseDouble("640.0"));

        Label label1 = new Label("Vacina:");
        label1.setLayoutX(Double.parseDouble("75.0"));;
        label1.setLayoutY(Double.parseDouble("6.0"));

        Label label2 = new Label("Nome:");
        label2.setLayoutX(Double.parseDouble("94.0"));;
        label2.setLayoutY(Double.parseDouble("35.0"));

        Label label3 = new Label("Fabricante:");
        label3.setLayoutX(Double.parseDouble("94.0"));;
        label3.setLayoutY(Double.parseDouble("110.0"));

        ChoiceBox<String> vacina = new ChoiceBox<String>();
        vacina.setLayoutX(Double.parseDouble("101.0"));
        vacina.setLayoutY(Double.parseDouble("58.0"));
        vacina.setPrefHeight(Double.parseDouble("25.0"));
        vacina.setPrefWidth(Double.parseDouble("302.0"));
        vacina.setId(("vacinaChoice" + Integer.toString(contador)));
        vacina.setItems(listaVacinas());

        ChoiceBox<String> fabricante = new ChoiceBox<String>();
        fabricante.setLayoutX(Double.parseDouble("101.0"));
        fabricante.setLayoutY(Double.parseDouble("127.0"));
        fabricante.setPrefHeight(Double.parseDouble("25.0"));
        fabricante.setPrefWidth(Double.parseDouble("302.0"));
        fabricante.setId(("fabricanteChoice" + Integer.toString(contador)));

        Button addDoenca = new Button("+" );
        addDoenca.setLayoutX(Double.parseDouble("544.0"));
        addDoenca.setLayoutY(Double.parseDouble("71.0"));
        addDoenca.setOnAction(event -> adicionarVacina());

        pane.getChildren().addAll(label1, label2, label3, vacina, fabricante, addDoenca);
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

    public void cadastrarAnimal(ActionEvent event){
        ObservableList<Node> children = cadastroContent.getChildren();
        List<Vacina> vacinas = new ArrayList<>();

        // Loop para capturar objetos de todos os campos gerados
        for (int i = 0; i < children.size(); i++) {
            Node node = children.get(i);
            String id = node.getId();

            if(id.contains("vacina")){
                String vacinaId = "#vacinaChoice" + id.substring(id.length()-1);
                String fabricanteId = "#fabricanteChoice" + id.substring(id.length()-1);

                ChoiceBox<String> choiceboxVacina = ((ChoiceBox<String>) node.lookup(vacinaId));
                String vacina = choiceboxVacina.getValue();

                ChoiceBox<String> choiceboxFabricante = ((ChoiceBox<String>) node.lookup(fabricanteId));
                String fabricante = choiceboxFabricante.getValue();

                if (vacina != null && fabricante != null) {
                    vacinas.add(VacinaService.buscarPorNome(vacina, fabricante));
                }
            }
        }

        // Elimina duplicações
        Set<Vacina> set = new HashSet<>(vacinas);
        vacinas = new ArrayList<>(set);

        String nome = nomeField.getText();
        String inputNasc = nascField.getText();
        String inputAcolhimento = acolhimentoField.getText();

        List<String> dados = new ArrayList<>();
        Collections.addAll(dados, nome, inputNasc, inputAcolhimento);

        if (!service.validarTextField(dados)){
            reiniciarContador();
            voltarInicio(event);
        }

        if(especieChoice.getValue() == null){
            reiniciarContador();
            voltarInicio(event);
        }

        Especie especie = EspecieService.especiePorNome(especieChoice.getValue());
        Date nasc = service.converterStringDate(inputNasc);
        Date acolhimento = service.converterStringDate(inputAcolhimento);

        Sexo sexo = sexoChoice.getValue();

        Animal animal = new Animal();
        animal.setNome(nome);
        animal.setData_nasc(nasc);
        animal.setData_acolhimento(acolhimento);
        animal.setEspecie(especie);
        animal.setSexo(sexo);
        animal.setVacinas(vacinas);
        service.salvarAnimal(animal);
        
        reiniciarContador();
        voltarInicio(event);
    }
}
