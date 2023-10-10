package SAX.Ejercicio1;

import SAX.Ejemplo.Libro;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class Manejador extends DefaultHandler {
    private String valor;
    private final ArrayList<Coche> coches;

    private Coche coche;

    public Manejador(ArrayList<Coche> coches) {
        this.coches = coches;
    }



    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        valor = null;
        if (qName.equals("coche")){
            coche = new Coche();
            int precio = Integer.parseInt(attributes.getValue("precio"));
            coche.setPrecio(precio);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valor = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "marca" -> coche.setMarca(valor);
            case "modelo" -> coche.setModelo(valor);
            case "combustible" -> coche.setCombustible(valor);
            case "cilindrada" -> coche.setCilindrada(Integer.parseInt(valor));
            case "potencia" -> coche.setPotencia(valor);
            case "coche" -> coches.add(coche);
        }
    }
}
