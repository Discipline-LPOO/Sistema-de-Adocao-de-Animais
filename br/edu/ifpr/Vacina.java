public class Vacina {
    private Long id;
    private String nome;
    private String fabricante;
    private List<Doenca> doencas;
}
    //Construtores
    public Vacina (Long id, String nome, String fabricante, List<Doenca> doencas) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.doencas = doencas;
    }
    //Getters e Setters
    public Long getId() {
        return id;
    }
    public Long setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public String setNome(String nome) {
        this.nome = nome;
    }
    public String getFabricante() {
        return fabricante;
    }
    public String setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public List<Doenca> getDoencas() {
        return doencas;
    }
    public List<Doenca> setDoencas(List<Doenca> doencas) {
        this.doencas = doencas;
    }
    
