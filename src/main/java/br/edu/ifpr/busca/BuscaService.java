package br.edu.ifpr.busca;

import br.edu.ifpr.adocao.Adocao;
import br.edu.ifpr.adocao.AdocaoDao;
import br.edu.ifpr.adocao.AdocaoService;
import br.edu.ifpr.adotante.Adotante;
import br.edu.ifpr.adotante.AdotanteDao;
import br.edu.ifpr.adotante.AdotanteService;
import br.edu.ifpr.animal.Animal;
import br.edu.ifpr.animal.AnimalDao;
import br.edu.ifpr.animal.AnimalService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuscaService {



    // TODO -> Talvez transformar os returns em Strings???
    public List<Object> buscar(String textoBusca, String ItemSelecionado) {
        return switch (ItemSelecionado) {
            case "Adotante: nome" -> Collections.singletonList(AdotanteService.selectPorNome(textoBusca));
            // TODO -> Adicionar lógica para ligar com a tela de resultado dependendo da query.
            case "Adotante: CPF" -> Collections.singletonList(AdotanteService.selectPorCPF(textoBusca));
            // TODO -> Idem, igual o de cima.
            case "Animal: nome" -> Collections.singletonList(AnimalService.selectPorNome(textoBusca));
            // TODO -> Idem, igual o de cima.
            case "Animal: data acolhimento" ->
                    Collections.singletonList(AnimalService.selectPorDataAcolhimento(textoBusca));
            // TODO -> Idem, igual o de cima.
            case "Adoção: data adoção" -> Collections.singletonList(AdocaoService.selectPorDataAdocao(textoBusca));
            // TODO -> Idem, igual o de cima.
            case "Adoção: nome adotante" -> Collections.singletonList(AdocaoService.selectPorNomeAdotante(textoBusca));
            // TODO -> Idem, igual o de cima.
            case "Adoção: nome animal" -> Collections.singletonList(AdocaoService.selectPorNomeAnimal(textoBusca));
            // TODO -> Idem, igual o de cima.
            default -> new ArrayList<>();
        };

    }

    public List<String> itensChoicebox() {
        return List.of(
                "Adotante: nome",
                "Adotante: CPF",
                "Animal: nome",
                "Animal: data acolhimento",
                "Adoção: data adoção",
                "Adoção: nome adotante",
                "Adoção: nome animal");
    }

    public String stringCastracao(boolean castracao) {
    if (castracao) {
        return "Sim";
    } else{
        return "Não";
    }
    }
}