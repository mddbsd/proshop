package net.cfl.proshop.servicios.usuario;

import net.cfl.proshop.modelo.Usuario;
import net.cfl.proshop.request.ActualizaUsuarioReq;
import net.cfl.proshop.request.AgregaUsuarioReq;

public interface IUsuarioServicio {
	Usuario traeUsuarioPorId(Long usuarioId);
	Usuario crearUsuario(AgregaUsuarioReq request);
	Usuario actualizarUsuario(ActualizaUsuarioReq request, Long usuarioId);
	void borrarUsuario(Long usuarioId);
}
