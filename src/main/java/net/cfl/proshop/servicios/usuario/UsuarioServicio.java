package net.cfl.proshop.servicios.usuario;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.cfl.proshop.excepciones.RecursoNoEncontradoEx;
import net.cfl.proshop.excepciones.UsuarioExisteEx;
import net.cfl.proshop.modelo.Usuario;
import net.cfl.proshop.repositorio.UsuarioRepositorio;
import net.cfl.proshop.request.ActualizaUsuarioReq;
import net.cfl.proshop.request.AgregaUsuarioReq;

@Service
@RequiredArgsConstructor
public class UsuarioServicio implements IUsuarioServicio{
	
	private final UsuarioRepositorio usuarioRepositorio;
	
	
	
	@Override
	public Usuario traeUsuarioPorId(Long usuarioId) {
		return usuarioRepositorio.findById(usuarioId)
				.orElseThrow(() -> new RecursoNoEncontradoEx("usuario no encontrado"));
	}

	@Override
	public Usuario crearUsuario(AgregaUsuarioReq request) {
		return Optional.of(request)
				.filter(usuario -> !usuarioRepositorio.existsByEmail(request.getEmail()))
				.map(req -> {
					Usuario usuario = new Usuario();
					usuario.setEmail(request.getEmail());
					usuario.setPwd(request.getPwd());
					usuario.setUsuarioNombre(request.getUsuarioNombre());
					usuario.setUsuarioApellido(request.getUsuarioApellido());
					return usuarioRepositorio.save(usuario);
				}).orElseThrow(() -> new UsuarioExisteEx("El usuario " + request.getEmail() + " ya existe"));
	}

	@Override
	public Usuario actualizarUsuario(ActualizaUsuarioReq request, Long usuarioId) {
		return usuarioRepositorio.findById(usuarioId).map(usuarioExistente -> {
			usuarioExistente.setUsuarioNombre(request.getUsuarioNombre());
			usuarioExistente.setUsuarioApellido(request.getUsuarioApellido());
			return usuarioRepositorio.save(usuarioExistente);
		}).orElseThrow(() -> new RecursoNoEncontradoEx("usuario no encontrado!")) ;
	}

	@Override
	public void borrarUsuario(Long usuarioId) {
		usuarioRepositorio.findById(usuarioId)
		.ifPresentOrElse(usuarioRepositorio :: delete, () ->{
			throw new RecursoNoEncontradoEx("usuario no encontrado!");
		});
		
	}

}
























