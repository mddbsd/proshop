package net.cfl.proshop.servicios.imagen;

import org.springframework.web.multipart.MultipartFile;

import net.cfl.proshop.modelo.Imagen;

public interface IImagenServicio {
	Imagen listaImagenPorId(Long id);
	void boarraImagenPorId(Long id);
	Imagen guardaImagen(MultipartFile archivo, Long productoId);
	void actualizaImagen(MultipartFile archivo, Long imagenId);
}
