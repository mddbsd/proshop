package net.cfl.proshop.servicios.orden;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.cfl.proshop.excepciones.RecursoNoEncontradoEx;
import net.cfl.proshop.modelo.Orden;
import net.cfl.proshop.modelo.OrdenItem;
import net.cfl.proshop.repositorio.OrdenRepositorio;

@Service
@RequiredArgsConstructor
public class OrdenServicio implements IOrdenServicio{
	private final OrdenRepositorio ordenRepositorio;
	@Override
	public Orden realizaOrden(Long usuarioId) {
		// TODO Apéndice de método generado automáticamente
		return null;
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
