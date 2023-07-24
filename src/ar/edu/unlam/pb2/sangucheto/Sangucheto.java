package ar.edu.unlam.pb2.sangucheto;

import java.util.ArrayList;


public class Sangucheto {

	private ArrayList<Ingrediente> ingredientes;
    private ArrayList<Condimento> condimentos;
    private Stock stock;
  
    
    public Sangucheto() {
        ingredientes = new ArrayList<>();
        condimentos = new ArrayList<>();
        this.stock = new Stock();
    }

    public Sangucheto(Stock stock) {
        this.stock = stock;
    }


	public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void agregarCondimento(Condimento condimento) {
        condimentos.add(condimento);
    }

    public double getPrecio() {
        double precioTotal = 0;
        for (Ingrediente ingrediente : ingredientes) {
            precioTotal += ingrediente.getPrecio();
        }
        for (Condimento condimento : condimentos) {
            precioTotal += condimento.getPrecio();
        }
        return precioTotal;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public ArrayList<Condimento> getCondimentos() {
        return condimentos;
    }

    public void cancelar() {
        ingredientes.clear();
        condimentos.clear();
    }

    public ArrayList<Ingrediente> listarIngredientesDisponibles() {
        return stock.consultarStockIngredientes();
    }

}
