public class NomeComum {
    private Long id;
    private String nome;
}
    //Construtor
    public NomeComum (Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
    