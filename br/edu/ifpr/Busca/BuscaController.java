package br.edu.ifpr.Busca;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import br.edu.ifpr.Busca.BuscaService;

// Adotante(nome do adotante, cpf do adotante)
// Animal(nome do animal, data de acolhimento)
// Adoção(data adoção, adotante, animal)

public class BuscaController {

    @FXML
    private TextField buscaField;

    @FXML
    private ChoiceBox<String> buscaChoice;

    private BuscaService buscaService = new BuscaService();
}