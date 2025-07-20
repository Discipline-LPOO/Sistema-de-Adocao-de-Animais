package br.edu.ifpr.especie;

import br.edu.ifpr.apelido.Apelido;
import br.edu.ifpr.doenca.Doenca;

import java.util.ArrayList;
import java.util.List;

public class EspecieService {

    private static EspecieDao dao = new EspecieDao();

    public static List<String> todasEspeciesComApelidos(){
        List<Especie> objetos = dao.todasEspecies();
        List<String> especies = new ArrayList<>();

        for(int i = 0; i < objetos.size(); i++){
            especies.add(objetos.get(i).getNome());
            List<Apelido> apelidos = objetos.get(i).getApelidos();

            for(int j = 0; j < apelidos.size(); j++){
                especies.add(apelidos.get(j).getNome());
            }
        }

        return especies;
    }

    public static Especie especiePorNome(String nome){
        return dao.especiePorNome(nome);
    };

    public boolean existe(String nome){
        List<String> especies = todasEspeciesComApelidos();

        if(especies.contains(nome)){
            return true;
        }

        return false;
    };

    public static void adicionarEspecie(Especie especie){
        dao.salvar(especie);
    };

    public static void atualizarEspecie(Especie especie){
        dao.atualizar(especie);
    };

    public boolean validateTextField(String text){
        if(text.trim().isEmpty() || text.isEmpty()){
            return  false;
        }
        return true;
    }


}
