package Ejercicio3;

import Ejercicio2.EstadoPartida;
import binariosObject.MiObjectOutputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class GuardarPersona {
    static File fichero = new File("FichPersona.dat");

    static File ficheroXML = new File("FichPersona.XML");

    static ArrayList<Persona> arrayPersonas = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String respuesta;
    public static void main(String[] args) throws IOException {

        menu();
    }

    private static void menu() throws IOException{

        System.out.println("¿Que desea hacer?");
        do {
            System.out.println("1-> Crear una persona");
            System.out.println("2-> Crear fichero Binario");
            System.out.println("3-> Crear archivo XML");
            System.out.println("4-> Leer archivo XML");
            System.out.println("5-> Salir");

            respuesta = br.readLine();
            switch (respuesta){
                case "1":
                    arrayPersonas.clear();
                    crearPersona();
                    break;
                case "2":
                    guardarPersona();
                    break;
                case "3":
                    escribirXML();
                case "4":
                    leerFicheroXML();
                default:
                    if (!respuesta.equals("5")){
                        System.out.println("Número no valido");
                    }
                    break;
            }

        }while(!(respuesta.equals("4")));
        System.out.println("Hasta la luego");

    }



    private static void leerFicheroXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(ficheroXML);

            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz: "+ doc.getDocumentElement().getNodeName());

            NodeList listaPersonas = doc.getElementsByTagName("Persona");

            for (int i = 0; i> listaPersonas.getLength(); i++){
                Node nodo = listaPersonas.item(i);
                System.out.println("Elemento: "+ nodo.getNodeName());

                if (nodo.getNodeType() == Node.ELEMENT_NODE){
                    Element persona= (Element) nodo;

                    System.out.println("Nombre: " + persona.getElementsByTagName("Nombre").item(0).getTextContent());
                    System.out.println("Edad: " + persona.getElementsByTagName("Edad").item(0).getTextContent());
                }



            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }


    private static void escribirXML() {
        try {
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element raiz = doc.createElement("Personas");
            doc.appendChild(raiz);
            Persona p = null;
            try {
                while (true){
                    p = (Persona) ois.readObject();
                    Element persona = doc.createElement("Persona");
                    raiz.appendChild(persona);
                    Element nombre = doc.createElement("Nombre");
                    nombre.setTextContent(p.getPersona());
                    persona.appendChild(nombre);

                    Element edad = doc.createElement("Edad");
                    edad.setTextContent(String.valueOf(p.getEdad()));
                    persona.appendChild(edad);
                }
            }catch (EOFException e) {
                System.out.println("Fin del fichero, se han leido todas las personas");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            DOMSource fuente = new DOMSource(doc);

            StreamResult result = new StreamResult(new FileOutputStream(ficheroXML));

            transformer.transform(fuente, result);
            result.getOutputStream().close();

        } catch (IOException | ParserConfigurationException | TransformerException e) {
            throw new RuntimeException(e);
        }

    }



    private static void guardarPersona() {
        //FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            ;
            if(fichero.exists()) {

                FileOutputStream fos = new FileOutputStream(fichero, true);
                oos = new MiObjectOutputStream(fos);
            }else {
                FileOutputStream fos = new FileOutputStream(fichero);
                oos = new MiObjectOutputStream(fos);
                System.out.println("Se a creado el fichero");
            }
        }catch (IOException e){
            System.out.println("Error"+e);
        }
        for (Persona p:arrayPersonas) {
            try {
                oos.writeObject(p);
            } catch (IOException e) {
                throw new RuntimeException("Error al escribir en fichero");
            }
        }
        try {
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        arrayPersonas.clear();
    }


    private static void crearPersona() {

        String nombre = "";
        int edad = 0;
        boolean error;

        try {
            do {
                System.out.println("Introduce los datos de la persona");
                System.out.println("Introduce el nombre");
                nombre = br.readLine();
                respuesta = "";
                do {
                    System.out.println("Introduce la edad");

                    try {
                        edad = Integer.parseInt(br.readLine());
                        error = false;
                        if (edad < 0 || edad > 150) {
                            System.out.println("No te flipes con la edad crack");
                            error = true;
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("La edad tiene que ser un número");
                        error = true;
                    }
                } while (error);
                Persona per = new Persona(nombre, edad);
                arrayPersonas.add(per);

                System.out.println("¿Desea continuar creando? ----> SI o NO ?");
                respuesta = br.readLine();


            }while (!respuesta.equalsIgnoreCase("no"));
            System.out.println(arrayPersonas.size());
        } catch (IOException e) {
            System.out.println("Error"+e);
        }
    }
}
