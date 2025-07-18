package br.edu.ifpr.Doenca;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.Apelido.Apelido;
import br.edu.ifpr.Apelido.ApelidoService;
import br.edu.ifpr.Doenca.DoencaDao;

public class DoencaService {

    private static DoencaDao dao = new DoencaDao();

    public static List<String> todasDoencas(){
        List<Doenca> objetos = dao.todasDoencas();
        List<String> doencas = new ArrayList<>();

        for(int i = 0; i < objetos.size(); i++){
            doencas.add(objetos.get(i).toString());
        }

        return doencas;
    }

    public boolean exists(String nome){
        List<String> nomes = todasDoencas();
        List<String> apelidosdoencas = new ArrayList<>();
        List<Apelido> apelidos = ApelidoService.apelidosDoencas();

        for(int i = 0; i < apelidos.size(); i++){
            apelidosdoencas.add(apelidos.get(i).toString());
        }

        nomes.addAll(apelidosdoencas);

        if(nomes.contains(nome)){
            return true;
        }
        return false;
    }

}
