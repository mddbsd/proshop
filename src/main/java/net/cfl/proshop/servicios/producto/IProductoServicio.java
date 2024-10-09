package net.cfl.proshop.servicios.producto;

import java.util.List;

import net.cfl.proshop.modelo.Producto;
import net.cfl.proshop.request.ActualizaProductoReq;
import net.cfl.proshop.request.AgregaProductoReq;

public interface IProductoServicio {
	//crud
	Producto agregaProducto(AgregaProductoReq request);
	Producto listaProductoPorId(Long id);
	void borrarProducto(Long id);
	Producto actualizaProducto(ActualizaProductoReq request, Long id);
	
	//filtros
	List<Producto> listarProductos();
	List<Producto> listarPorCategoria(String categoria);
	List<Producto> listarPorMarca(String marca);
	List<Producto> listarPorMarcaYCategoria(String marca, String categoria);
	List<Producto> listarPorNombre(String nombre);
	List<Producto> listarPorNombreYMarca(String nombre, String marca);
	Long contarProductosPorNombreYMarca(String nombre, String marca);
	
	
}
