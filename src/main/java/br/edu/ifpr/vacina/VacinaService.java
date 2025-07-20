package br.edu.ifpr.vacina;

import br.edu.ifpr.doenca.DoencaService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VacinaService {
    private static VacinaDao dao = new VacinaDao();

    public static List<String> todasVacinas(){
        List<Vacina> objetos = dao.todasVacinas();
        List<String> vacinas = new ArrayList<>();

        for (int i = 0; i<objetos.size(); i++){
            vacinas.add(objetos.get(i).getNome());
        }

        Set<String> set = new HashSet<String>(vacinas);
        vacinas = new ArrayList<>(set);

        return vacinas;
    }

    public static List<String> fabricantePorNomeVacina(String nome){
        List<Vacina> objetos = dao.todasVacinasPorNome(nome);
        List<String> fabricantes = new ArrayList<>();

        for (int i = 0; i<objetos.size(); i++){
            fabricantes.add(objetos.get(i).getFabricante());
        }

        Set<String> set = new HashSet<String>(fabricantes);
        fabricantes = new ArrayList<>(set);

        return fabricantes;
    }

    public static boolean existe(String nome, String fabricante){
        try{
            Vacina vacina = buscarPorNome(nome, fabricante);
        }
        catch(Exception NoResultException){
            return false;
        }
        return true;
    }

    public static Vacina buscarPorNome(String nome, String fabricante){
        return dao.buscarVacinaPorNomeFabricante(nome, fabricante);
    }

    public void adicionarVacina(Vacina vacina) {
        dao.salvar(vacina);
    }

    public void atualizarVacina(Vacina vacina){
        dao.atualizar(vacina);
    }
}
