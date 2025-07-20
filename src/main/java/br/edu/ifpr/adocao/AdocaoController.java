package br.edu.ifpr.adocao;

import br.edu.ifpr.adotante.AdotanteDao;
import br.edu.ifpr.adotante.AdotanteService;
import br.edu.ifpr.animal.Animal;
import br.edu.ifpr.animal.AnimalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AdocaoController implements Initializable {
    private AdocaoService service = new AdocaoService();

    private List<Animal> animaisDisponiveis = AnimalService.todosAnimaisAdotados();

    @FXML
    private TextField cpfField;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField dataField;

    @FXML
    private ChoiceBox<String> animalChoice;

    @FXML
    private Label verificado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        ObservableList<String> animais = FXCollections.observableArrayList(listaAnimais());
        animalChoice.setItems(animais);
    }


    private List<String> listaAnimais(){
        List<String> animais = AnimalService.nomesAnimaisNaoAdotados();
        return animais;
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

    public void adotanteVerificado(ActionEvent event){
        if(AdotanteService.existe(cpfField.getText())){
            verificado.setVisible(true);
        }
        else {
            verificado.setVisible(false);
        }
    }

    public void listarAnimais(ActionEvent event){
        String nome = nomeField.getText();
        List<String> animaisDisponiveis = listaAnimais();

        List<String> animais = new ArrayList<>();

        for(int i = 0; i < animaisDisponiveis.size(); i++){
            if(nome != null && animaisDisponiveis.contains(nome)){
                animais.add(animaisDisponiveis.get(i));
            }
        }

        if(animais.isEmpty()){
            ObservableList<String> listaAnimais = FXCollections.observableArrayList(animaisDisponiveis);
            animalChoice.setItems(listaAnimais);
        }
        else {
            ObservableList<String> listaAnimais = FXCollections.observableArrayList(animais);
            animalChoice.setItems(listaAnimais);
        }
    }

    public void salvarAdocao(ActionEvent event){
        if (verificado.isVisible() && service.validarData(dataField.getText())){
            Date data = service.converterData(dataField.getText());
            String nome = animalChoice.getValue();
            String nomeAtual;
            Animal animal = null;
            for (int i = 1; i < animaisDisponiveis.size(); i++){
                nomeAtual = animaisDisponiveis.get(i).getNome();
                if (nome.equals(nomeAtual)){
                    animal = animaisDisponiveis.get(i);
                    break;
                }
            }

            if (animal != null){
                Adocao adocao = new Adocao();
                adocao.setData(data);
                adocao.setAdotante(AdotanteService.selectPorCPF(cpfField.getText()));
                adocao.setAnimal(animal);

            }

            voltarInicio(event);
        }
    }

}
