package net.cfl.proshop.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OrdenItemDto {
	private Long productoId;
	private String productoNombre;
	private int cantidad;
	private BigDecimal precio;
}
