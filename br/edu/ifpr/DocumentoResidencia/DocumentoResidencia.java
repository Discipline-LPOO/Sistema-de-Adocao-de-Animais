package br.edu.ifpr.DocumentoResidencia;

// Importação de bibliotecas
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.awt.Image;

@AllArgsConstructor
@Getter
@Setter
public class DocumentoResidencia {
    private int id;
    private Image arquivo;
}
