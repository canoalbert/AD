package SAX.Ejemplo;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class SAXMain {
    public static void main(String[] args) {
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            SAXParserFactory saxpf = SAXParserFactory.newInstance();
            SAXParser saxParser = saxpf.newSAXParser();

            XMLReader reader = saxParser.getXMLReader();
            reader.setContentHandler(new Manejador(libros));

            reader.parse(new InputSource(new FileInputStream("src/SAX/Ejemplo/ejemploSAX.xml")));

            System.out.println("*** RESULTADO ***");
            for (Libro l:libros){
                System.out.println(l);
                System.out.println("**************");
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
