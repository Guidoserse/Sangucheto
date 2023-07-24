package ar.edu.unlam.pb2.sangucheto;

public class Condimento {

	private String nombre;
    private double precio;

    public Condimento(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

}
