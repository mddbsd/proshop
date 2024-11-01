package net.cfl.proshop.servicios.carrito;

import java.math.BigDecimal;

import net.cfl.proshop.modelo.Carrito;

public interface ICarritoServicio {
	Carrito traeCarrito(Long id);
	void limpiaCarrito(Long id);
	BigDecimal traePrecioTotal(Long id);
	Long inicializaCarrito();
	
}
