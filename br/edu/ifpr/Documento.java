import br.edu.ifpr.Enumeration.TipoDocumento;

public class Documento {
    private Long id;
    private TipoDocumento tipo;
    private String numeracao;
    private Blob arquivo;
}
    //Construtor
public Documento(Long id, TipoDocumento tipo, String numeracao, Blob arquivo) {
    this.id = id;
    this.tipo = tipo;
    this.numeracao = numeracao;
    this.arquivo = arquivo;
}
    //Getters e Setters
    public Long getId() {
        return id;
}
    public void setId(Long id) {
        this.id = id;
}
    public TipoDocumento getTipo() {
        return tipo;
}
    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
}
    public String getNumeracao() {
        return numeracao;
}
    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
}
    public Blob getArquivo() {
        return arquivo;
}
    public void setArquivo(Blob arquivo) {
        this.arquivo = arquivo;
}