package net.cfl.proshop.servicios.carrito;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.cfl.proshop.modelo.Carrito;
import net.cfl.proshop.repositorio.CarritoRepositorio;

@Service
@RequiredArgsConstructor
public class CarritoServicio implements ICarritoServicio{
	private final CarritoRepositorio carritoRepositorio;
	@Override
	public Carrito traeCarrito(Long id) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

	@Override
	public void limpiaCarrito(Long id) {
		// TODO Apéndice de método generado automáticamente
		
	}

	@Override
	public BigDecimal traePrecioTotal(Long id) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}

}
