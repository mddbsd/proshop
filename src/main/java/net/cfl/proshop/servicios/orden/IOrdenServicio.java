package net.cfl.proshop.servicios.orden;

import java.util.List;

import net.cfl.proshop.modelo.Orden;

public interface IOrdenServicio {
	Orden realizaOrden(Long usuarioId);
	Orden traeOrden(Long ordenId);
	List<Orden> traeUsuarioOrdenes(Long usuarioId);
}
