package br.edu.ifpr.adocao;

import br.edu.ifpr.animal.Animal;
import br.edu.ifpr.animal.AnimalDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdocaoService {
    private static AdocaoDao dao = new AdocaoDao();

    public static List<Adocao> todasAdocoes(){
        return dao.todasAdocoes();
    }

    public boolean validarData(String data){
        if (converterData(data) != null){
            return true;
        }
        return false;
    }

    public Date converterData(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            return sdf.parse(data);
        }
        catch (ParseException e) {
            return null;
        }
    }

    public static List<Adocao> selectPorDataAdocao(String textoBusca) {
        return dao.selectPorDataAdocao(textoBusca);
    }

    public static List<Adocao> selectPorNomeAdotante(String textoBusca) {
        return dao.selectPorNomeAdotante(textoBusca);
    }

    public static List<Adocao> selectPorNomeAnimal(String textoBusca) {
        return dao.selectPorNomeAnimal(textoBusca);
    }
}
