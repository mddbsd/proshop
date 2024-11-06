package net.cfl.proshop.modelo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal costoTotal = BigDecimal.ZERO;
	
	@OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<CarritoItem> carritoItems = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	
	
	public void agregaItem(CarritoItem item) {
		this.carritoItems.add(item);
		item.setCarrito(this);
		actualizaCostoTotal();
	}
	
	public void quitaItem(CarritoItem item) {
		this.carritoItems.remove(item);
		item.setCarrito(this);
		actualizaCostoTotal();
	}
	
	private void actualizaCostoTotal() {
		this.costoTotal = carritoItems
				.stream()
				.map(item -> {
					BigDecimal precioUnitario = item.getPrecioUni();
					if (precioUnitario == null) {
						return BigDecimal.ZERO;
					}
					return precioUnitario.multiply(BigDecimal.valueOf(item.getCantidad()));
				}).reduce(BigDecimal.ZERO, BigDecimal :: add);
	}
}





















