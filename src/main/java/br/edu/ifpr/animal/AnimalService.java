package br.edu.ifpr.animal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AnimalService {
    public static AnimalDao dao = new AnimalDao();

    public void salvarAnimal(Animal animal){
        dao.salvar(animal);
    }

    public static boolean validarTextField(List<String> inputs){
        if(inputs.get(0).isEmpty() || inputs.get(0) == null){
            return false;
        }

        if(converterStringDate(inputs.get(1)) == null || converterStringDate(inputs.get(2)) == null){
            return false;
        }

        return true;
    }

    public static Date converterStringDate(String data){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            return sdf.parse(data);
        }
        catch (ParseException e) {
            return null;
        }
    }
}
