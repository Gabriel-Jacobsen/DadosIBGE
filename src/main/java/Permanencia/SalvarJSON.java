package Permanencia;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;

public class SalvarJSON {

    public static void salvarComoJson(Object objeto, String caminhoArquivo) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File(caminhoArquivo), objeto);
        } catch (Exception e) {
            e.printStackTrace();
        }
	
    }
}
