package br.edu.ifpr.adotante;


import jakarta.persistence.NoResultException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdotanteService {

    private static AdotanteDao adotanteDao = new AdotanteDao();
    // private DocumentoResidenciaService documentoResidenciaService = new DocumentoResidenciaService();
    // Ainda precisa dos docs de residência e identidade

    public static void cadastrarAdotante(String nome, String cpf, String telefone, String endereco) {
        Adotante adotante = new Adotante();
        adotante.setNome(nome);
        adotante.setCpf(cpf);
        adotante.setTelefone(telefone);
        // Adicionar docs residência
        // Adicionar docs identidade
        adotanteDao.salvar(adotante);
    }

    public static boolean existe(String cpf){
        try{
            adotanteDao.selectPorCPF(cpf);
        }
        catch (NoResultException e){
            return false;
        }
        return true;
    }

    public static List<Adotante> selectPorNome(String nome){
        return adotanteDao.selectPorNome(nome);
    }

    public static Adotante selectPorCPF(String cpf){
        return adotanteDao.selectPorCPF(cpf);
    }

}
