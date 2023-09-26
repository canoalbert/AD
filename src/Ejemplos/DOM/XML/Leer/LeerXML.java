package Ejemplos.DOM.XML.Leer;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class LeerXML {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File fichero = new File("src/Ejemplos/DOM/XML/Leer/LeerConDOM.XML");

        // Crear documento
        DocumentBuilderFactory dbf =
                DocumentBuilderFactory.newInstance();
        DocumentBuilder db =
                dbf.newDocumentBuilder();

        Document doc = db.parse(fichero);


        doc.getDocumentElement().normalize();

        //Leer documento

        System.out.println("Elemento raiz: "
                +doc.getDocumentElement().getNodeName());

        NodeList listaEmpleados =
                doc.getElementsByTagName("empleado");

        for (int i = 0; i < listaEmpleados.getLength(); i++) {
            Node nodo = listaEmpleados.item(i);
            System.out.println("Elemento "+nodo.getNodeName());

            if (nodo.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) nodo;

                System.out.println("id: "
                        +element.getAttribute("id"));

                System.out.println("Nombre: "
                        + element.getElementsByTagName("nombre")
                        .item(0).getTextContent());
                System.out.println("Username: "
                        + element.getElementsByTagName("username")
                        .item(0).getTextContent());
                System.out.println("Password: "
                        + element.getElementsByTagName("password")
                        .item(0).getTextContent());

            }

        }

    }
}
