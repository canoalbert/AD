package SAX.Ejercicio1;

public class Coche {
    private String precio;
    private String marca;
    private String modelo;
    private String combustible;
    private int cilindrada;
    private String potencia;

    public Coche(String precio, String marca, String modelo, String combustible, int cilindrada, String potencia) {
        this.precio = precio;
        this.marca = marca;
        this.modelo = modelo;
        this.combustible = combustible;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
    }


    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public Coche() {
    }

    @Override
    public String toString() {
        return "Coche{" +
                "precio='" + precio + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", combustible='" + combustible + '\'' +
                ", cilindrada=" + cilindrada +
                ", potencia='" + potencia + '\'' +
                '}';
    }
}
