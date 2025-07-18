package br.edu.ifpr.apelido;

import java.util.ArrayList;
import java.util.List;

public class ApelidoService {
    private static ApelidoDao dao = new ApelidoDao();

    public static List<String> todosApelidosDoencas(){
        List<Apelido> apelidos = dao.todosApelidosDoencas();
        List<String> apelidosDoencas = new ArrayList<String>();

        for(int i = 0; i < apelidos.size(); i++){
            apelidosDoencas.add(apelidos.get(i).getNome());
        }

        return apelidosDoencas;
    }

    public static List<String> todosApelidosEspecies(){
        List<Apelido> apelidos = dao.todosApelidosEspecies();
        List<String> apelidosEspecies = new ArrayList<String>();

        for(int i = 0; i < apelidos.size(); i++){
            apelidosEspecies.add(apelidos.get(i).getNome());
        }

        return apelidosEspecies;
    }

    public static boolean existe(String nomeField){
        return true;
    }
}
