package br.edu.ifpr.busca;

import br.edu.ifpr.adocao.Adocao;
import br.edu.ifpr.adocao.AdocaoDao;
import br.edu.ifpr.adotante.Adotante;
import br.edu.ifpr.adotante.AdotanteDao;
import br.edu.ifpr.animal.Animal;
import br.edu.ifpr.animal.AnimalDao;

import java.util.List;

public class BuscaService {
// TODO -> Talvez transformar em string os returns???
    public void buscar(String textoBusca, String getItemSelecionado) {
        switch(getItemSelecionado) {
            case "Adotante: nome":
                List<Adotante> resultadoAdotanteNome = AdotanteDao.selectPorNome(textoBusca);
                // Adicionar lógica para ligar com a tela de resultado dependendo da query.
                break;
            case "Adotante: CPF":
                List<Adotante> resultadoAdotanteCpf = AdotanteDao.selectPorCPF(textoBusca);
                // Adicionar lógica para ligar com a tela de resultado dependendo da query.
                break;
            case "Animal: nome":
                List<Animal> resultadoAniNome = AnimalDao.selectPorNome(textoBusca);
                // Adicionar lógica para ligar com a tela de resultado dependendo da query.
                break;
            case "Animal: data acolhimento":
                List<Animal> resultadoAniDataAcolhimento = AnimalDao.selectPorDataAcolhimento(textoBusca);
                // Adicionar lógica para ligar com a tela de resultado dependendo da query.
                break;
            case "Adoção: data adoção":
                List<Adocao> resultadoAdocaoData = AdocaoDao.selectPorDataAdocao(textoBusca);
                // Adicionar lógica para ligar com a tela de resultado dependendo da query.
                break;
            case "Adoção: nome adotante":
                List<Adocao> resultadoAdocaoNomeAdotante = AdocaoDao.selectPorNomeAdotante(textoBusca);
                // Adicionar lógica para ligar com a tela de resultado dependendo da query.
                break;
            case "Adoção: nome animal":
                List<Adocao> resultadoAdocaoNomeAnimal = AdocaoDao.selectPorNomeAnimal(textoBusca);
                // Adicionar lógica para ligar com a tela de resultado dependendo da query.
                break;
        }

    }

}