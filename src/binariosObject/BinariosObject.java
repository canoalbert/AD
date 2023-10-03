package binariosObject;

import java.io.*;

public class BinariosObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File fichero = new File("./FicheroObject.dat");

        EscribirObjeto(fichero);

        LeerObjeto(fichero);


    }

    private static void LeerObjeto(File fichero) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(fichero);

            ObjectInputStream ois = new ObjectInputStream(fis);

            Persona p;
            while (true){
                p = (Persona) ois.readObject();
                System.out.println(p.toString());
            }
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }catch (EOFException eofe){
            System.out.println("Fin del fichero");
        }catch (IOException ioe){
            System.out.println("Error en Lectura de fichero" +ioe);
        }

    }





    private static void EscribirObjeto(File fichero) throws IOException {

        try {
            ObjectOutputStream oos;
            if(fichero.exists()){
                FileOutputStream fos = new FileOutputStream(fichero, true);
                oos = new MiObjectOutputStream(fos);
            }else {
                FileOutputStream fos = new FileOutputStream(fichero);
                oos = new MiObjectOutputStream(fos);
            }


            String nombres[] = {"Ana", "Pedro", "Laura", "Miguel", "Manuel", "Sara"};
            int[] edades = {23, 22, 19, 25, 24, 26};

            for (int i = 0; i < nombres.length; i++) {
                oos.writeObject(new Persona(nombres[i], edades[i]));
            }
            oos.close();
        }catch (Exception e) {

            System.out.println("Error en Escritura de fichero" + e);
        }
    }
}
