package ar.edu.unlam.pb2.sangucheto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestSangucheto {

	private Stock stock;
	private Sangucheto sangucheto;

	@Test
	public void testArmarSangucheto() {
		stock = new Stock();
		stock.darDeAltaIngrediente(new Ingrediente("Pan", 1.5));
		stock.darDeAltaIngrediente(new Ingrediente("Jamón", 2.0));
		stock.darDeAltaIngrediente(new Ingrediente("Queso", 1.0));
		stock.darDeAltaCondimento(new Condimento("Mayonesa", 0.5));
		stock.darDeAltaCondimento(new Condimento("Mostaza", 0.3));

		sangucheto = new Sangucheto();

		Ingrediente pan = new Ingrediente("Pan", 1.5);
		Ingrediente jamon = new Ingrediente("Jamón", 2.0);
		Condimento mayonesa = new Condimento("Mayonesa", 0.5);

		stock.agregarStockIngrediente(pan, 2);
		stock.agregarStockIngrediente(jamon, 1);
		stock.agregarStockCondimento(mayonesa, 1);

		sangucheto.agregarIngrediente(pan);
		sangucheto.agregarIngrediente(jamon);
		sangucheto.agregarCondimento(mayonesa);

		assertEquals(4.0, sangucheto.getPrecio(), 0.01);
		assertTrue(sangucheto.getIngredientes().contains(pan));
		assertTrue(sangucheto.getIngredientes().contains(jamon));
		assertTrue(sangucheto.getCondimentos().contains(mayonesa));
	}

	@Test
	public void testCancelarSangucheto() {

		stock = new Stock();
		stock.darDeAltaIngrediente(new Ingrediente("Pan", 1.5));
		stock.darDeAltaIngrediente(new Ingrediente("Jamón", 2.0));
		stock.darDeAltaIngrediente(new Ingrediente("Queso", 1.0));
		stock.darDeAltaCondimento(new Condimento("Mayonesa", 0.5));
		stock.darDeAltaCondimento(new Condimento("Mostaza", 0.3));

		sangucheto = new Sangucheto();

		Ingrediente pan = new Ingrediente("Pan", 1.5);
		Ingrediente jamon = new Ingrediente("Jamón", 2.0);
		Condimento mayonesa = new Condimento("Mayonesa", 0.5);

		stock.agregarStockIngrediente(pan, 2);
		stock.agregarStockIngrediente(jamon, 1);
		stock.agregarStockCondimento(mayonesa, 1);

		sangucheto.agregarIngrediente(pan);
		sangucheto.agregarIngrediente(jamon);
		sangucheto.agregarCondimento(mayonesa);

		sangucheto.cancelar();

		assertEquals(0.0, sangucheto.getPrecio(), 0.01);
		assertTrue(sangucheto.getIngredientes().isEmpty());
		assertTrue(sangucheto.getCondimentos().isEmpty());
	}

	@Test
	//2. Listar todos los ingredientes disponibles.
	//3. Consultar el stock de todos los ingredientes del stock, tengan o no stock (es decir, los ingredientes con cantidad 0 son incluidos).

	public void testListarIngredientesDisponibles() {

		Stock stock = new Stock();
		Sangucheto sangucheto = new Sangucheto(stock);

		Ingrediente tomate = new Ingrediente("Tomate", 0.5);
		Ingrediente lechuga = new Ingrediente("Lechuga", 0.3);
		Ingrediente queso = new Ingrediente("Queso", 1.2);
		Ingrediente jamon = new Ingrediente("Jamon", 1.5);

		stock.agregarStockIngrediente(tomate, 10);
		stock.agregarStockIngrediente(lechuga, 5);
		stock.agregarStockIngrediente(queso, 20);
		stock.agregarStockIngrediente(jamon, 15);

		ArrayList<Ingrediente> ingredientesDisponibles = sangucheto.listarIngredientesDisponibles();

		assertTrue(ingredientesDisponibles.contains(tomate));
		assertTrue(ingredientesDisponibles.contains(lechuga));
		assertTrue(ingredientesDisponibles.contains(queso));
		assertTrue(ingredientesDisponibles.contains(jamon));
	}

	@Test
	//4. Dar de alta un ingrediente (con cantidad en 0).
	public void testDarDeAltaIngredienteConCantidadCero() {
	    Stock stock = new Stock();
	    Ingrediente ingrediente = new Ingrediente("Tomate", 0.5);

	    stock.darDeAltaIngredienteConCantidadCero(ingrediente, 0);

	    int stockActual = stock.getStockIngrediente(ingrediente);
	    assertEquals(0, stockActual);
	}
	
	@Test
	//5. Agregar stock a determinado ingrediente, es decir se suma a lo que tiene.
	public void testAgregarStockIngredienteExistente() {
	    Stock stock = new Stock();
	    Ingrediente tomate = new Ingrediente("Tomate", 0.5);
	    stock.darDeAltaIngredienteConCantidadCero(tomate, 5);

	    int stockInicial = stock.getStockIngrediente(tomate);
	    assertEquals(5, stockInicial);

	    stock.agregarStockIngrediente(tomate, 3);

	    int stockActualizado = stock.getStockIngrediente(tomate);
	    assertEquals(8, stockActualizado);
	}
	
	@Test
	
	//6. Obtener el stock disponible de un determinado ingrediente
	public void testObtenerStockIngrediente() {
	    Stock stock = new Stock();
	    Ingrediente tomate = new Ingrediente("Tomate", 0.5);

	    // Agregar ingredientes al stock
	    stock.darDeAltaIngredienteConCantidadCero(tomate, 5);
	    stock.agregarStockIngrediente(tomate, 3);

	    // Obtener el stock disponible del ingrediente
	    int stockDisponible = stock.getStockIngrediente(tomate);

	    // Verificar que el stock disponible sea el esperado
	    assertEquals(8, stockDisponible);
	}
	
	@Test
	//7. Determinar la existencia de un determinado ingrediente.
	public void testExistenciaIngrediente() {
	    Stock stock = new Stock();
	    Ingrediente tomate = new Ingrediente("Tomate", 0.5);
	    Ingrediente lechuga = new Ingrediente("Lechuga", 0.3);

	    // Dar de alta ingredientes en el stock
	    stock.darDeAltaIngrediente(tomate);
	    stock.darDeAltaIngrediente(lechuga);

	    // Verificar existencia de ingredientes
	    assertTrue(stock.existeIngrediente(tomate));
	    assertTrue(stock.existeIngrediente(lechuga));
	    assertFalse(stock.existeIngrediente(new Ingrediente("Queso", 1.2)));
	}
	
	@Test
	//8. Comprar ingrediente, indicando la cantidad a descontar de la existencia.
	public void testComprarIngrediente() {
	    Stock stock = new Stock();
	    Ingrediente tomate = new Ingrediente("Tomate", 0.5);
	    stock.darDeAltaIngrediente(tomate);
	    stock.agregarStockIngrediente(tomate, 10);
	    
	    assertTrue(stock.comprarIngrediente(tomate, 5));
	    assertFalse(stock.comprarIngrediente(tomate, 10));
	}
	

	
}
