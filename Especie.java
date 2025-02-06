public class Especie {
    private Long id;
    private String nome;
    private List<NomeComum> apelidos;
}
    //Construtor
    public Especie (Long id, String nome, List<NomeComum> apelidos) {
        this.id = id;
        this.nome = nome;
        this.apelidos = apelidos;
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
    public List<NomeComum> getApelidos() {
        return apelidos;
    }
    public List<NomeComum> setApelidos(List<NomeComum> apelidos) {
        this.apelidos = apelidos;
    }