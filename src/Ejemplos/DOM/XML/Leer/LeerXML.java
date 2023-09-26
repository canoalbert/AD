package Ejemplos.DOM.XML.Leer;

import org.w3c.dom.NodeList;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LeerXML {
    public static void main(String[] args) {
        File fichero = new File("LeerConDOM.XML");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.parse(fichero);
        Document doc = db.parse(fichero);
        doc.getDocumentElement().normalize();
        System.out.println("Elemento Raiz: " + doc.getDocumentElement().getNodeName());

        NodeList listaEmpleados = doc.getElementsByTagname("empleado");

    }
}
