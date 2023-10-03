package SAX.Ejemplo;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class Manejador extends DefaultHandler {
    private  String valor;
    private final ArrayList<Libro> libros;
    private Libro libro;

    public Manejador(ArrayList<Libro> libros) {
        this.libros = libros;
    }


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        valor = null;
        if(qName.equals("libro")){
            libro = new Libro();
            String isbn = attributes.getValue("ISBN");
            libro.setIsbn(isbn);
        }

    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        valor = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case "titulo" -> libro.setTitulo(valor);
            case "autor" -> libro.setAutor(valor);
            case "anyo" -> libro.setAnyo(Integer.parseInt(valor));
            case "editorial" -> libro.setEditorial(valor);
            case "libro" -> libros.add(libro);
        }
    }
}
