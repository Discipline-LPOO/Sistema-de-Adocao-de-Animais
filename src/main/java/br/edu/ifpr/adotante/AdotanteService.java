package br.edu.ifpr.adotante;


import jakarta.persistence.NoResultException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdotanteService {

    private Adotante adotante = new Adotante();
    private AdotanteDao adotanteDao = new AdotanteDao();
    // private DocumentoResidenciaService documentoResidenciaService = new DocumentoResidenciaService();
    // Ainda precisa dos docs de residência e identidade
    public void cadastrarAdotante(String nome, String cpf, String telefone, String endereco) {
        adotante.setNome(nome);
        adotante.setCpf(cpf);
        adotante.setTelefone(telefone);
        // Adicionar docs residência
        // Adicionar docs identidade
        adotanteDao.salvar(adotante);
    }

    public static boolean existe(String cpf){
        try{
            AdotanteDao.selectPorCPF(cpf);
        }
        catch (NoResultException e){
            return false;
        }
        return true;
    }

}
