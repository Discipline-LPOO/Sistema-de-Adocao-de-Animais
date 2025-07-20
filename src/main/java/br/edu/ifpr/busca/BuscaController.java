package br.edu.ifpr.busca;


import br.edu.ifpr.adocao.Adocao;
import br.edu.ifpr.adotante.Adotante;
import br.edu.ifpr.animal.Animal;
import br.edu.ifpr.animal.Sexo;
import br.edu.ifpr.especie.Especie;
import javafx.beans.Observable;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;


public class BuscaController implements Initializable {

    // Variáveis da tela de Busca
    @FXML
    private TextField buscaField;

    @FXML
    private ChoiceBox<String> buscaChoice;

    // Variáveis da tela de Resultado
    // Variáveis de Adocao
    @FXML
    private TableView<Adocao> adocaoTable;

    @FXML
    private TableColumn<Adocao, Date> dataAdocao;

    @FXML
    private TableColumn<Adocao, String> adotanteAdocao;

    @FXML
    private TableColumn<Adocao, String> cpfAdocao;

    @FXML
    private TableColumn<Adocao, String> animalAdocao;

    // Variáveis de Adotante
    @FXML
    private TableView<Adotante> adotanteTable;

    @FXML
    private TableColumn<Adotante, String> nomeAdotante;

    @FXML
    private TableColumn<Adotante, String> cpfAdotante;

    @FXML
    private TableColumn<Adotante, String> telefoneAdotante;

    @FXML
    private TableColumn<Adotante, String> enderecoAdotante;

    // Variáveis de Animal
    @FXML
    private TableView<Animal> animalTable1;

    @FXML
    private TableColumn<Animal, String> nomeAnimal;

    @FXML
    private TableColumn<Animal, String> especieAnimal;

    @FXML
    private TableColumn<Animal, Integer> idadeAnimal;

    @FXML
    private TableColumn<Animal, Date> acolhimentoAnimal;

    @FXML
    private TableColumn<Animal, String> sexoAnimal;

    @FXML
    private TableColumn<Animal, String> castradoAnimal;

    @FXML
    private TableColumn<Animal, String> adotadoAnimal;

    @FXML
    private TableColumn<Animal, String> vacinasAnimal;

    // Service instanciado

    private List<Object> retornosBusca;
    private final BuscaService buscaService = new BuscaService();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (buscaChoice != null) {
            buscaChoice.getItems().addAll(buscaService.itensChoicebox());
        }


        if (dataAdocao != null) {
            dataAdocao.setCellValueFactory(new PropertyValueFactory<>("data_adocao"));
        }

        if (adotanteAdocao != null) {
            adotanteAdocao.setCellValueFactory(valorCelulaAdotanteNome -> {
                String nomeAdotante = valorCelulaAdotanteNome.getValue().getAdotante().getNome();
                return new ReadOnlyObjectWrapper<>(nomeAdotante);
            });
        }

        if (cpfAdocao != null) {
            cpfAdocao.setCellValueFactory(valorCelulaCpf -> {
                String cpfAdotante = valorCelulaCpf.getValue().getAdotante().getCpf();
                return new ReadOnlyObjectWrapper<>(cpfAdotante);
            });
        }

        if (animalAdocao != null) {
            animalAdocao.setCellValueFactory(valorCelulaAnimalNome -> {
                String nomeAnimal = valorCelulaAnimalNome.getValue().getAnimal().getNome();
                return new ReadOnlyObjectWrapper<>(nomeAnimal);
            });
        }


        if (nomeAdotante != null) {
            nomeAdotante.setCellValueFactory(new PropertyValueFactory<>("nome"));
        }

        if (cpfAdotante != null) {
            cpfAdotante.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        }

        if (telefoneAdotante != null) {
            telefoneAdotante.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        }

        if (enderecoAdotante != null) {
            enderecoAdotante.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        }


        if (nomeAnimal != null) {
            nomeAnimal.setCellValueFactory(new PropertyValueFactory<>("nome"));
        }

        if (especieAnimal != null) {
            especieAnimal.setCellValueFactory(valorCelulaAnimalEspecie -> {
                String especieAnimal = valorCelulaAnimalEspecie.getValue().getEspecie().getNome();
                return new ReadOnlyObjectWrapper<>(especieAnimal);
            });
        }

        if (idadeAnimal != null) {
            idadeAnimal.setCellValueFactory(valorCelulaAnimalIdade -> {
                Animal ani = valorCelulaAnimalIdade.getValue();
                Date data_nasc = ani.getData_nasc();
                LocalDate data_nascLocal = LocalDate.ofInstant(data_nasc.toInstant(), ZoneId.systemDefault());
                int idade = Period.between(data_nascLocal, LocalDate.now()).getYears();
                return new ReadOnlyObjectWrapper<>(idade);
            });
        }

        if (acolhimentoAnimal != null) {
            acolhimentoAnimal.setCellValueFactory(new PropertyValueFactory<>("data_acolhimento"));
        }

        if (sexoAnimal != null) {
            sexoAnimal.setCellValueFactory(valorCelulaSexo -> {
                Sexo sexo = valorCelulaSexo.getValue().getSexo();
                return new ReadOnlyStringWrapper(sexo.name());
            });
        }

        if (castradoAnimal != null) {
            castradoAnimal.setCellValueFactory(valorCelulaCastracao ->
                    new ReadOnlyStringWrapper(buscaService.stringCastracao(valorCelulaCastracao.getValue().getCastracao())));
        }

        // todo -> query para animais adotados
        if (adotadoAnimal != null) {
            adotadoAnimal.setCellValueFactory(new PropertyValueFactory<>("data_adocao"));// todo
        }

        if (vacinasAnimal != null) {
            vacinasAnimal.setCellValueFactory(new PropertyValueFactory<>("animais_vacinas"));
        }
    }

    public void iniciarBusca(ActionEvent event) throws IOException {
        FXMLLoader loaderBusca = new FXMLLoader(getClass().getResource("Busca.fxml"));
        Parent rootBusca = loaderBusca.load();
        Stage stageBusca = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene sceneBusca = new Scene(rootBusca);
        stageBusca.setScene(sceneBusca);
        stageBusca.show();
    }

    public void buscar(ActionEvent event) throws IOException {
        // Retorna a query com base no que foi pesquisado.
        List<Object> retornosBusca = buscaService.buscar(buscaField.getText(), buscaChoice.getValue());
        // Abre a tela de resultado
        FXMLLoader loaderResultado = new FXMLLoader(getClass().getResource("Resultado.fxml"));
        Parent rootResultado = loaderResultado.load();
        Stage stageResultado = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene sceneResultado = new Scene(rootResultado);
        stageResultado.setScene(sceneResultado);
        stageResultado.show();

        // Programa escolhe qual tabela de acordo com o query
        ObservableList<Object> query = FXCollections.observableArrayList(retornosBusca);

        // Adiciona na tabela o query correto
    }

    public void voltarMenu(ActionEvent event) throws IOException {
        FXMLLoader loaderMenu = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent rootMenu = loaderMenu.load();
        Stage stageMenu = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene sceneMenu = new Scene(rootMenu);
        stageMenu.setScene(sceneMenu);
        stageMenu.show();
    }
    
    // Não consegui fazer as funções de retorno funcionar
    // (Elas chamariam o resultado das querys e carregarias as tables)
    /*
    public void carregarAdotante() {
         List<Adotante> listaAdotante = Collections.singletonList(((Adotante) retornosBusca));
    }

    public void carregarAdocao() {
        List<Adotante> listaAdotante = Collections.singletonList(((Adocao) retornosBusca));
    }

    public void carregarAnimal() {
        List<Adotante> listaAdotante = Collections.singletonList(((Animal) retornosBusca));
    }
    */
}