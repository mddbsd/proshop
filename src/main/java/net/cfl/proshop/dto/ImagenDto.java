package net.cfl.proshop.dto;

import java.sql.Blob;

import lombok.Data;

@Data
public class ImagenDto {
	private Long id;
	private String archivoNombre;
	private String archivoTipo;
	private Blob imagen;
	private String descargaUrl;
}
