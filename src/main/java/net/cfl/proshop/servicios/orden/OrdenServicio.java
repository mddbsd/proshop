package net.cfl.proshop.servicios.orden;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.cfl.proshop.enums.OrdenEstado;
import net.cfl.proshop.excepciones.RecursoNoEncontradoEx;
import net.cfl.proshop.modelo.Carrito;
import net.cfl.proshop.modelo.Orden;
import net.cfl.proshop.modelo.OrdenItem;
import net.cfl.proshop.modelo.Producto;
import net.cfl.proshop.repositorio.OrdenRepositorio;
import net.cfl.proshop.repositorio.ProductoRepositorio;

@Service
@RequiredArgsConstructor
public class OrdenServicio implements IOrdenServicio{
	private final OrdenRepositorio ordenRepositorio;
	private final ProductoRepositorio productoRepositorio;
	@Override
	public Orden realizaOrden(Long usuarioId) {
		// TODO Apéndice de método generado automáticamente
		return null;
	}
	
	
	private List<OrdenItem> crearOrdenItem(Orden orden, Carrito carrito){
		return carrito.getCarritoItems().stream().map(carritoItem -> {
			Producto producto = carritoItem.getProducto();
			producto.setStock(producto.getStock() - carritoItem.getCantidad());
			productoRepositorio.save(producto);
			return new OrdenItem(
					orden, 
					producto, 
					carritoItem.getCantidad(), 
					carritoItem.getPrecioUni());
		}).toList();
	} 
	
	private Orden crearOrden(Carrito carrito) {
		Orden orden = new Orden();
		// Establecer el usuario
		orden.setOrdenEstado(OrdenEstado.PENDIENTE);
		orden.setOrdenFecha(LocalDate.now());
		return orden;
	}
	
	
	private BigDecimal calculaMontoTotal(List<OrdenItem> listaDeItems) {
		return listaDeItems
				.stream()
				.map(item -> item.getPrecio()
						.multiply(new BigDecimal(item.getCantidad())))
				.reduce(BigDecimal.ZERO, BigDecimal :: add);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public Orden traeOrden(Long ordenId) {
		return ordenRepositorio.findById(ordenId)
				.orElseThrow(() -> new RecursoNoEncontradoEx("Orden No encontrada"));
	}
	

}
