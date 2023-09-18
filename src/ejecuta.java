import java.io.*;
import java.nio.Buffer;

public class ejecuta {
    public static void main(String[] args) throws IOException {
        File fichero = new File("FicheroData.bat");


        FileOutputStream fileout = new FileOutputStream(fichero, true);
        DataOutputStream fileDataOut = new DataOutputStream(fileout);


        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream fileData = new DataInputStream(filein);


        String nombres[] = {"Ana", "Pedro", "Laura", "Miguel", "Manuel", "Sara"};
        int[] edades = {23,22,19,25,24,26};


        for (int i = 0; i < edades.length; i++) {
            fileDataOut.writeUTF(nombres[i]);
            fileDataOut.writeInt(edades[i]);
        }
        fileDataOut.close();


        String n;
        int e;


        try{
            while(true){
                n = fileData.readUTF();
                e = fileData.readInt();
                System.out.println("Nombre: " + n + "Edad: " + e);
            }
        }catch (EOFException eof){
            System.out.println("Fin del fichero");
        }
        fileData.close();
    }

}
