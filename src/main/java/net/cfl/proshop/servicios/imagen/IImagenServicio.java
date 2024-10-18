package net.cfl.proshop.servicios.imagen;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import net.cfl.proshop.dto.ImagenDto;
import net.cfl.proshop.modelo.Imagen;

public interface IImagenServicio {
	Imagen listaImagenPorId(Long id);
	void borraImagenPorId(Long id);
	List<ImagenDto> guardaImagenes(List<MultipartFile> archivo, Long productoId);
	void actualizaImagen(MultipartFile archivo, Long imagenId);
}
