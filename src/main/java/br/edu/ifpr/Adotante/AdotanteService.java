package br.edu.ifpr.Adotante;

//import br.edu.ifpr.DocumentoResidencia.DocumentoResidencia;
//import br.edu.ifpr.DocumentoResidencia.DocumentoResidenciaService;

public class AdotanteService {

    private Adotante adotante = new Adotante();
    private AdotanteDao adotanteDao = new AdotanteDao();
    // private DocumentoResidenciaService documentoResidenciaService = new DocumentoResidenciaService();
    // Ainda precisa dos docs de residência e identidade
    public void cadastrarAdotante(String nome, String cpf, String telefone, String endereco) {
        adotante.setNome(nome);
        adotante.setCpf(cpf);
        adotante.setTelefone(telefone);
        adotante.setEndereco(endereco);
        // Adicionar docs residência
        // Adicionar docs identidade
        adotanteDao.salvar(adotante);
    }
}
