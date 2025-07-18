package br.edu.ifpr.Busca;

import br.edu.ifpr.Adocao.Adocao;
import br.edu.ifpr.Adocao.AdocaoDao;
import br.edu.ifpr.Adotante.Adotante;
import br.edu.ifpr.Adotante.AdotanteDao;
import br.edu.ifpr.Animal.Animal;
import br.edu.ifpr.Animal.AnimalDao;

import java.util.List;

public class BuscaService {
// TODO -> Talvez transformar os returns em Strings???
    public void buscar(String textoBusca, String ItemSelecionado) {
        switch(ItemSelecionado) {
            case "Adotante: nome":
                List<Adotante> resultadoAdotanteNome = AdotanteDao.selectPorNome(textoBusca);
                // TODO -> Adicionar lógica para ligar com a tela de resultado dependendo da query.
                break;
            case "Adotante: CPF":
                List<Adotante> resultadoAdotanteCpf = AdotanteDao.selectPorCPF(textoBusca);
                // TODO -> Idem, igual o de cima.
                break;
            case "Animal: nome":
                List<Animal> resultadoAniNome = AnimalDao.selectPorNome(textoBusca);
                // TODO -> Idem, igual o de cima.
                break;
            case "Animal: data acolhimento":
                List<Animal> resultadoAniDataAcolhimento = AnimalDao.selectPorDataAcolhimento(textoBusca);
                // TODO -> Idem, igual o de cima.
                break;
            case "Adoção: data adoção":
                List<Adocao> resultadoAdocaoData = AdocaoDao.selectPorDataAdocao(textoBusca);
                // TODO -> Idem, igual o de cima.
                break;
            case "Adoção: nome adotante":
                List<Adocao> resultadoAdocaoNomeAdotante = AdocaoDao.selectPorNomeAdotante(textoBusca);
                // TODO -> Idem, igual o de cima.
                break;
            case "Adoção: nome animal":
                List<Adocao> resultadoAdocaoNomeAnimal = AdocaoDao.selectPorNomeAnimal(textoBusca);
                // TODO -> Idem, igual o de cima.
                break;
        }

    }

    public List<String> itensChoicebox() {
        List<String> itens = List.of(
                "Adotante: nome",
                "Adotante: CPF",
                "Animal: nome",
                "Animal: data acolhimento",
                "Adoção: data adoção",
                "Adoção: nome adotante",
                "Adoção: nome animal");
        return itens;
    }

}