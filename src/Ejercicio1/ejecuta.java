package Ejercicio1;

import java.io.*;
import java.nio.Buffer;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ejecuta {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        File fichero = new File("./FicheroCuenta.dat");
        CargarCantidad(fichero);
        AbonarCantidad(fichero);

    }

    public static void CargarCantidad(File fichero)  throws IOException, ClassNotFoundException {

            Process ProcespHijo = new ProcessBuilder();





    }
    public static void AbonarCantidad(File fichero) throws IOException{
        try {

        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }catch (EOFException eofe){
            System.out.println("Fin del fichero");
        }catch (IOException ioe){
            System.out.println("Error en Lectura de fichero" +ioe);
        }

    }

}
