package net.cfl.proshop.servicios.carrito;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import net.cfl.proshop.excepciones.RecursoNoEncontradoEx;
import net.cfl.proshop.modelo.Carrito;
import net.cfl.proshop.modelo.CarritoItem;
import net.cfl.proshop.repositorio.CarritoItemRepositorio;
import net.cfl.proshop.repositorio.CarritoRepositorio;

@Service
@RequiredArgsConstructor
public class CarritoServicio implements ICarritoServicio{
	private final CarritoRepositorio carritoRepositorio;
	private final CarritoItemRepositorio carritoItemRepositorio;
	private final AtomicLong generadorId = new AtomicLong(0);
	@Override
	public Carrito traeCarrito(Long id) {
		Carrito carrito = carritoRepositorio.findById(id)
				.orElseThrow(() -> new RecursoNoEncontradoEx("Carrito No Encontrado"));
		BigDecimal montoTotal = carrito.getCostoTotal();
		carrito.setCostoTotal(montoTotal);
		return carritoRepositorio.save(carrito);
	}

	@Transactional //Permite la ejecucion en bloque de las consultas SQL
	@Override
	public void limpiaCarrito(Long id) {
		Carrito carrito = traeCarrito(id);		
		carritoItemRepositorio.deleteAllByCarritoId(id);
		carrito.getCarritoItems().clear();
		carritoRepositorio.deleteById(id);
	}

	@Override
	public BigDecimal traePrecioTotal(Long id) {
		Carrito carrito = traeCarrito(id);
		return carrito.getCostoTotal();
	}
	
	/* Metodo utilizado para generar ids de carritos sin auth
	 * del usuario, solo lo aplicamos para probra la api
	 * en esta etapa donde todavia no implementamos
	 * la gestion de usuarios
	 * */
	@Override
	public Long inicializaCarrito() {
		Carrito nuevoCarrito = new Carrito();
		Long nuevoCarritoId = generadorId.incrementAndGet();
		nuevoCarrito.setId(nuevoCarritoId);
		return carritoRepositorio.save(nuevoCarrito).getId();
	}
	
	@Override
	public Carrito traeCarritoPorUsuarioId(Long usuarioId) {
		return carritoRepositorio.findByUsuarioId(usuarioId);
	}
	

}























