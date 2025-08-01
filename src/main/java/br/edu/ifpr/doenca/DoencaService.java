package br.edu.ifpr.doenca;

import br.edu.ifpr.apelido.Apelido;
import br.edu.ifpr.apelido.ApelidoService;

import java.util.ArrayList;
import java.util.List;

public class DoencaService {

    private static DoencaDao dao = new DoencaDao();

    public static List<String> todasDoencas() {
        List<Doenca> objetos = dao.todasDoencas();
        List<String> doencas = new ArrayList<>();

        for (int i = 0; i < objetos.size(); i++) {
            doencas.add(objetos.get(i).getNome());
        }
        return doencas;
    }

    public static List<String> todasDoencasComApelidos(){
        List<Doenca> objetos = dao.todasDoencas();
        List<String> doencas = new ArrayList<>();

        // Matriz para desencapsular os apelidos de cada doenca
        for(int i = 0; i < objetos.size(); i++){
            doencas.add(objetos.get(i).getNome());
            List<Apelido> apelidos = objetos.get(i).getApelidos();

            for(int j = 0; j < apelidos.size(); j++){
                doencas.add(apelidos.get(j).getNome());
            }
        }

        return doencas;
    }


    public  static Doenca doencaPorNome(String nome) {
        return dao.buscaPorNome(nome);
    }

    public boolean existe(String nome){
        List<String> doencas = todasDoencasComApelidos();

        if(doencas.contains(nome)){
            return true;
        }

        return false;
    }

    public void adicionarDoenca(Doenca doenca){
        String nome = doenca.getNome();

        if(nome.length() >= 2) {
            doenca.setNome(nome.substring(0, 1).toUpperCase() + nome.substring(1));
        }
        else {
            return;
        }

        List<Apelido> apelidos = doenca.getApelidos();

        if(apelidos.size() > 0){
            for(int i = 0; i < apelidos.size(); i++){

                if(ApelidoService.existe(apelidos.get(i).getNome())){

                }
            }
        }
    }

    public boolean validateTextField(String text){
        if(text.trim().isEmpty() || text.isEmpty()){
            return  false;
        }
        return true;
    }

    public void atualizarDoenca(Doenca doenca){
        dao.atualizar(doenca);
    }

}
