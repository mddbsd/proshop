package net.cfl.proshop.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.cfl.proshop.enums.OrdenEstado;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrdenItem {
	private Long id;
	private int cantidad;
	private BigDecimal precio;
	
	@ManyToOne
	@JoinColumn(name = "orden_id")
	private Orden orden;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	
	public OrdenItem(Orden orden, Producto producto, int cantidad, BigDecimal precio) {
		this.orden = orden;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
}
