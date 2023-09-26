package Ejemplos.DOM.XML.Escribir;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class EscribirXML {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        Element raiz = doc.createElement("root");
        doc.appendChild(raiz);


        raiz.appendChild(doc.createTextNode("\n"));

        Element element1 = doc.createElement("element");
        raiz.appendChild(element1);
        raiz.appendChild(doc.createTextNode("\n"));

        Attr atributo = doc.createAttribute("id");
        atributo.setValue("Valor del atributo");
        element1.setAttributeNode(atributo);

        Element element2 = doc.createElement("element2");
        element2.setTextContent("Contenido del elemento");

        raiz.appendChild(element2);
        raiz.appendChild(doc.createTextNode("\n"));

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();

        DOMSource fuente = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("element.XML"));
        transformer.transform(fuente,result);

    }
}
