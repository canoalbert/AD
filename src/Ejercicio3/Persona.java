package Ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.Serializable;

public class Persona implements Serializable {


    String persona;
    int edad;


    public Persona(String persona, int edad) {
        this.persona = persona;
        this.edad = edad;
    }



    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public int getEdad() {
        return edad;
    }

    public void setApellido(int edad) {
        this.edad = edad;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        return "Persona{" +
                "persona='" + persona + '\'' +
                ", apellido='" + edad + '\'' +
                '}';
    }
}
