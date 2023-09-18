package Ejercicio1;

import java.io.Serializable;

public class Movimientos implements Serializable {
    private String cargo;
    private String abono;
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getAbono() {
        return abono;
    }

    public void setAbono(String abono) {
        this.abono = abono;
    }


    public Movimientos() {
    }


    public Movimientos(String cargo, String abono) {
        this.cargo = cargo;
        this.abono = abono;
    }

    @Override
    public String toString() {
        return "Movimientos{" +
                "cargo='" + cargo + '\'' +
                ", abono='" + abono + '\'' +
                '}';
    }
}
