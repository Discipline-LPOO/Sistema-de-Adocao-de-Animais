package br.edu.ifpr.doenca;

import java.util.List;

public class DoencaController {

    public void salvarDoencaNome(String nomeField){
        String nome = nomeField;
        Doenca doenca = new Doenca();

        doenca.setNome(nome);
        DoencaService.adicionarDoenca(doenca);
    }

    public void salvarDoencaComApelido(String nomeField, List<String> apelidosField){
        String nome = nomeField;
        List<String> apelidos = apelidosField;
        Doenca doenca = new Doenca();
        doenca.setNome(nome);

        for (int i = 0; i < apelidos.size(); i++){

        }

        DoencaService.adicionarDoenca(doenca);
    }

}
