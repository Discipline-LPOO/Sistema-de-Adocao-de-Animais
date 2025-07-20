package br.edu.ifpr.animal;

import br.edu.ifpr.adocao.Adocao;
import br.edu.ifpr.adocao.AdocaoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalService {
    public static AnimalDao dao = new AnimalDao();

    public void salvarAnimal(Animal animal){
        dao.salvar(animal);
    }

    public static boolean validarTextField(List<String> inputs){
        if(inputs.get(0).isEmpty() || inputs.get(0) == null){
            return false;
        }

        if(converterStringDate(inputs.get(1)) == null || converterStringDate(inputs.get(2)) == null){
            return false;
        }

        return true;
    }

    public static Date converterStringDate(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            return sdf.parse(data);
        }
        catch (ParseException e) {
            return null;
        }
    }

    public static List<Animal> todosAnimaisAdotados(){
        List<Adocao> adocoes = AdocaoService.todasAdocoes();
        List<Animal> animais = new ArrayList<>();
        for(int i = 0; i < adocoes.size(); i++){
            animais.add(adocoes.get(i).getAnimal());
        }
        return animais;
    }

    public static List<Animal> todosAnimaisNaoAdotados(){
        List<Animal> todosAnimais = dao.todosAnimais();
        List<Animal> animaisAdotados = todosAnimaisAdotados();
        List<Animal> animaisNaoAdotados = new ArrayList<>();

        for(int i = 0; i < todosAnimais.size(); i++){
            if(!animaisAdotados.contains(todosAnimais.get(i))){
                animaisNaoAdotados.add(todosAnimais.get(i));
            }
        }
        return animaisNaoAdotados;
    }

    public static List<String> nomesAnimaisNaoAdotados(){
        List<Animal> animaisNaoAdotados = todosAnimaisNaoAdotados();
        List<String> nomesAnimais = new ArrayList<>();

        for(int i = 0; i < animaisNaoAdotados.size(); i++){
            nomesAnimais.add(animaisNaoAdotados.get(i).getNome());
        }

        return nomesAnimais;
    }

    public static List<Animal> selectPorNome(String textoBusca){
        return dao.selectPorNome(textoBusca);
    }

    public static List<Animal> selectPorDataAcolhimento(String textoBusca) {
        return dao.selectPorDataAcolhimento(textoBusca);
    }

}
