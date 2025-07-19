package br.edu.ifpr.doenca;

import java.util.List;

public class DoencaController {

    private DoencaService service = new DoencaService();

    public void salvarDoencaNome(String nome){
        Doenca doenca = new Doenca();
        doenca.setNome(nome);
        DoencaService.adicionarDoenca(doenca);
    }

    public void salvarDoencaComApelido(String nome, List<String> apelidosField){
        List<String> apelidos = apelidosField;
        Doenca doenca = new Doenca();
        doenca.setNome(nome);

        for (int i = 0; i < apelidos.size(); i++){
            int num = 1;
        }

        DoencaService.adicionarDoenca(doenca);
    }

}
