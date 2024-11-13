package net.cfl.proshop.servicios.orden;

import java.util.List;

import net.cfl.proshop.dto.OrdenDto;
import net.cfl.proshop.modelo.Orden;

public interface IOrdenServicio {
	Orden realizaOrden(Long usuarioId);
	OrdenDto traeOrden(Long ordenId);
	List<OrdenDto> traeUsuarioOrdenes(Long usuarioId);
}
