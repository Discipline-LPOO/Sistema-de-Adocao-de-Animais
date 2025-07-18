package br.edu.ifpr.Busca;

import br.edu.ifpr.Adocao.AdocaoDao;
import br.edu.ifpr.Adotante.AdotanteDao;
import br.edu.ifpr.Animal.AnimalDao;

public class BuscaService {

    public void buscar(String textoBusca, String getItemSelecionado) {
        switch(getItemSelecionado) {
            case "Adotante: nome":
                return AdotanteDao.selectPorNome(textoBusca);
                break;
            case "Adotante: CPF":
                return AdotanteDao.selectPorCPF(textoBusca);
                break;
            case "Animal: nome":
                return AnimalDao.selectPorNome(textoBusca);
                break;
            case "Animal: data acolhimento":
                return AnimalDao.selectPorDataAcolhimento(textoBusca);
                break;
            case "Adoção: data adoção":
                return AdocaoDao.selectPorDataAdocao(textoBusca);
                break;
            case "Adoção: nome adotante":
                return AdocaoDao.selectPorNomeAdotante(textoBusca);
                break;
            case "Adoção: nome animal":
                return AdocaoDao.selectPorNomeAnimal(textoBusca);
                break;
        }

    }

}