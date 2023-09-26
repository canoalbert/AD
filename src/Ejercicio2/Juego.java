package Ejercicio2;

import java.io.*;

public class Juego {
    static File fichero = new File("PartidaGuardada.dat");
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String respuesta;
    public static void main(String[] args) throws IOException {
        menu();
    }

    private static void menu() throws IOException {
        System.out.println("Hola, Bienvenido al juego de tu vida");
        do {
            System.out.println("Selecciona opcion: ");
            System.out.println("1. Guardar partida");
            System.out.println("2. Cargar partida");
            System.out.println("3. Salir");

            respuesta = br.readLine();

            switch (respuesta){
                case "1":
                    guardarPartida();
                    break;
                case "2":
                   EstadoPartida partida = recuperarPartida();
                    System.out.println(partida);
                    break;
                default:
                    if (!respuesta.equals("3")){
                        System.out.println("Número no valido");
                    }
                    break;
            }
        }while(!(respuesta.equals("3")));
        System.out.println("Hasta la vista baby");
    }

    private static void guardarPartida() throws IOException {
        boolean error = true;
        int vidas =  calcularPantalla("vidas");
        int pantalla = calcularPantalla("pantalla");
        EstadoPartida ep = new EstadoPartida(vidas,pantalla);

        FileOutputStream fos = new FileOutputStream(fichero);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        try {
            oos.writeObject(ep);
            oos.close();
        }catch (IOException e){
            System.out.println("Error al escribir el objeto en fichero");
        }
    }

    private static int calcularPantalla(String tipo) throws IOException {
        boolean error = false;
        int datos = 0;

        do {
            System.out.print("Dime " + tipo + ": ");

                respuesta = br.readLine();
                try {
                    datos = Integer.parseInt(respuesta);
                    error = false;
            } catch (NumberFormatException e) {
                    System.out.println("La respuesta tiene que ser un numero");
                    error = true;
            }
        }while(error);
        System.out.println("Partida guardada.");
        return datos;
    }

    private static EstadoPartida recuperarPartida() {
        System.out.println("Estos son los datos de la partida: ");
        FileInputStream fis = null;
        EstadoPartida ep = null;
        ObjectInputStream ois = null;
        try {
             fis = new FileInputStream(fichero);
        } catch (FileNotFoundException e) {
            System.out.println("Error al acceder al fichero");
        }
        try {
             ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            System.out.println("Error al crear el flujo de datos de lectura");
        }
        try {
            ep = (EstadoPartida) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error en la lectura del objecto o clase no encontrada");
        }
        System.out.println("Partida cargada.");
        return ep;
    }


}
