package Ejercicio3;

import Ejercicio2.EstadoPartida;
import binariosObject.MiObjectOutputStream;

import java.io.*;
import java.util.ArrayList;

public class GuardarPersona {
    static File fichero = new File("FichPersona.dat");

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
            System.out.println("2-> Guardar una persona");
            System.out.println("3-> Leer fichero");
            System.out.println("4-> Salir");

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
                    leerFichero();
                default:
                    if (!respuesta.equals("4")){
                        System.out.println("Número no valido");
                    }
                    break;
            }

        }while(!(respuesta.equals("4")));
        System.out.println("Hasta la luego");

    }

    private static void leerFichero() {
    }

    private static void guardarPersona() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            ;
            if(fichero.exists()) {
                fos = new FileOutputStream(fichero, true);
                oos = new MiObjectOutputStream(fos);
            }else {
                fos = new FileOutputStream(fichero);
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
                throw new RuntimeException("Error"+e);
            }
        }

        try {
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    private static void crearPersona() {

        String nombre = "";
        int edad = 0;

        try {
            do {
                System.out.println("Introduce los datos de la persona");
                System.out.println("Introduce el nombre");
                nombre = br.readLine();
                System.out.println("Introduce la edad");
                edad = Integer.parseInt(br.readLine());

                Persona per = new Persona(nombre, edad);
                arrayPersonas.add(per);
                System.out.println("¿Desea continuar creando? ----> 1 = SI,   2 = NO ");
                respuesta = br.readLine();


            }while (!respuesta.equals("2"));
        } catch (IOException e) {
            System.out.println("Error"+e);
        }
    }
}
