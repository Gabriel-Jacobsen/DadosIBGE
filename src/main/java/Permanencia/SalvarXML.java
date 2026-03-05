package Permanencia;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class SalvarXML {
    public static void salvarComoXml(Object objeto, String caminhoArquivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(objeto.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(objeto, new File(caminhoArquivo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
