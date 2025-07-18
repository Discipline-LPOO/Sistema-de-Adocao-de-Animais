package br.edu.ifpr.Busca;

import br.edu.ifpr.Adocao.Adocao;
import br.edu.ifpr.Adocao.AdocaoDao;
import br.edu.ifpr.Adotante.Adotante;
import br.edu.ifpr.Adotante.AdotanteDao;
import br.edu.ifpr.Animal.Animal;
import br.edu.ifpr.Animal.AnimalDao;

import java.util.List;

public class BuscaEResultadoService {

    public List<?> buscar(String textoBusca, String getItemSelecionado) {
        switch(getItemSelecionado) {
            case "Adotante: nome":
                List<Adotante> resultadoAdotanteNome = AdotanteDao.selectPorNome(textoBusca);
                return resultadoAdotanteNome;
                break;
            case "Adotante: CPF":
                List<Adotante> resultadoAdotanteCpf = AdotanteDao.selectPorCPF(textoBusca);
                return resultadoAdotanteCpf;
                break;
            case "Animal: nome":
                List<Animal> resultadoAniNome = AnimalDao.selectPorNome(textoBusca);
                return resultadoAniNome;
                break;
            case "Animal: data acolhimento":
                List<Animal> resultadoAniDataAcolhimento = AnimalDao.selectPorDataAcolhimento(textoBusca);
                return resultadoAniDataAcolhimento;
                break;
            case "Adoção: data adoção":
                List<Adocao> resultadoAdocaoData = AdocaoDao.selectPorDataAdocao(textoBusca);
                return resultadoAdocaoData;
                break;
            case "Adoção: nome adotante":
                List<Adocao> resultadoAdocaoNomeAdotante = AdocaoDao.selectPorNomeAdotante(textoBusca);
                return resultadoAdocaoNomeAdotante;
                break;
            case "Adoção: nome animal":
                List<Adocao> resultadoAdocaoNomeAnimal = AdocaoDao.selectPorNomeAnimal(textoBusca);
                return resultadoAdocaoNomeAnimal;
                break;

        }
    }



}