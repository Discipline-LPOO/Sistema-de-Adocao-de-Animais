package br.edu.ifpr.vacina;

public class VacinaService {

    private static VacinaDao dao = new VacinaDao();

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
