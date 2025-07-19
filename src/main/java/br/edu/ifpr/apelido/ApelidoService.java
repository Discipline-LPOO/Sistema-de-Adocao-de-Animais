package br.edu.ifpr.apelido;

import java.util.ArrayList;
import java.util.List;

public class ApelidoService {
    private static ApelidoDao dao = new ApelidoDao();

    public static List<String> todosApelidos(){
        List<Apelido> apelidos = dao.todosApelidos();
        List<String> strApelidos = new ArrayList<>();

        for (int i = 0; i < apelidos.size(); i++) {
            strApelidos.add(apelidos.get(i).getNome());
        }

        return strApelidos;
    }

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
        try{
            dao.buscarPorNome(nomeField);
        }
        catch(Exception NoResultException){
            return false;
        }
        return true;
    }

    public static Apelido buscarPorNome(String nomeField){
        return dao.buscarPorNome(nomeField);
    }

    public static void adicionarApelido(Apelido apelido){
        dao.salvar(apelido);
    }
}
