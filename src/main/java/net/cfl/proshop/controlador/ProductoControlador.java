package net.cfl.proshop.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.cfl.proshop.modelo.Producto;
import net.cfl.proshop.respuesta.ApiRespuesta;
import net.cfl.proshop.servicios.categoria.ICategoriaServicio;
import net.cfl.proshop.servicios.producto.IProductoServicio;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/productos")
public class ProductoControlador {
	private final IProductoServicio productoServicio;
	
	@GetMapping("/todos")
	public ResponseEntity<ApiRespuesta> listaTodosProductos(){
		List<Producto> productos = productoServicio.listarProductos();
		return ResponseEntity.ok(new ApiRespuesta("Exito!", productos));
	}
	
	public ResponseEntity<ApiRespuesta> listarProductoPorId(Long productoId){
		Producto producto = productoServicio.listaProductoPorId(productoId);
		return ResponseEntity.ok(new ApiRespuesta("Exito!", producto));
	}
	
	
}
