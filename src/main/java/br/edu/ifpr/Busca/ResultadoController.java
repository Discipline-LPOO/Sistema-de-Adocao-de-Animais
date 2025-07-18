import br.edu.ifpr.Busca.BuscaEResultadoService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.Setter;

public class ResultadoController {

    @FXML
    private TextField resultadoField;


    @Setter
    private BuscaEResultadoService buscaEResultadoService;
    // TODO -> Lembrar de instanciar isso na Main


    
}