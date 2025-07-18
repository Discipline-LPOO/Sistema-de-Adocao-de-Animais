package br.edu.ifpr.Apelido;

import br.edu.ifpr.Dao.Dao;

import java.util.ArrayList;
import java.util.List;

public class ApelidoDao extends Dao<Apelido> {

    public static List<Apelido> apelidosDoencas(){
        List<Apelido> apelidos = new ArrayList<Apelido>();
        String sql = "SELECT nome FROM apelidos, apelidos_doencas WHERE apelidos.id_doenca = apelidos_doenca.id_doenca";
    }
}
