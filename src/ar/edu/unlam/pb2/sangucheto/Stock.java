package ar.edu.unlam.pb2.sangucheto;

import java.util.ArrayList;

public class Stock {
	private ArrayList<Ingrediente> ingredientes;
    private ArrayList<Condimento> condimentos;

    public Stock() {
        ingredientes = new ArrayList<>();
        condimentos = new ArrayList<>();
    }

    public void darDeAltaIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void darDeAltaIngredienteConCantidadCero(Ingrediente ingrediente, int cantidadInicial) {
        for (int i = 0; i < cantidadInicial; i++) {
            ingredientes.add(ingrediente);
        }
    }
    
    public void darDeAltaCondimento(Condimento condimento) {
        condimentos.add(condimento);
    }

    public boolean existeIngrediente(Ingrediente ingrediente) {
        return ingredientes.contains(ingrediente);
    }

    public int getStockIngrediente(Ingrediente ingrediente) {
        int stock = 0;
        for (Ingrediente item : ingredientes) {
            if (item.equals(ingrediente)) {
                stock++;
            }
        }
        return stock;
    }

    public void agregarStockIngrediente(Ingrediente ingrediente, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            ingredientes.add(ingrediente);
        }
    }

   
    public void eliminarStockIngrediente(Ingrediente ingrediente) {
        ingredientes.remove(ingrediente);
    }
    
    public void agregarStockCondimento(Condimento condimento, int cantidad) {
       
    	for (int i = 0; i < cantidad; i++) {
            condimentos.add(condimento);
        }
    }
    
    public void eliminarStockCondimento(Condimento condimento) {
    	condimentos.remove(condimento);
    }

    
    public ArrayList<Ingrediente> consultarStockIngredientes() {
        return ingredientes;
    }
    
    public boolean comprarIngrediente(Ingrediente ingrediente, int cantidad) {
        int stockActual = getStockIngrediente(ingrediente);
        if (stockActual >= cantidad) {
            for (int i = 0; i < cantidad; i++) {
                eliminarStockIngrediente(ingrediente);
            }
            return true; // Se pudo comprar el ingrediente
        } else {
            // No hay suficiente stock
            return false;
        }
    }
    
    public boolean eliminarStockIngrediente(Ingrediente ingrediente, int cantidad) {
        if (existeIngrediente(ingrediente) && cantidad > 0) {
            int stockActual = getStockIngrediente(ingrediente);
            if (cantidad <= stockActual) {
                for (int i = 0; i < cantidad; i++) {
                    ingredientes.remove(ingrediente);
                }
                return true;
            }
        }
        return false;
    }
    
}