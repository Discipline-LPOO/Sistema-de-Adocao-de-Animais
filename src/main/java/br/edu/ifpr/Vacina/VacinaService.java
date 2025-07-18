package br.edu.ifpr.Vacina;

public class VacinaService {

    private static VacinaDao dao = new VacinaDao();

    public static boolean existe(String nome, String fabricante){
        try{
            Vacina vacina = dao.buscarVacinaPorNomeFabricante(nome, fabricante);
        }
        catch(Exception NoResultException){
            return false;
        }
        return true;
    }

    public static void adicionarVacina(Vacina vacina) {
        dao.salvar(vacina);
    }
}
