package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IUsuarioUseCase;
import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.dominio.repositorio.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase {

	private final IUsuarioRepositorio repositorio;

	public UsuarioUseCaseImpl(IUsuarioRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {
		String contrasenaEncriptada = BCrypt.hashpw(nuevoUsuario.getContrasenaHash(), BCrypt.gensalt());
		nuevoUsuario.setContrasenaHash(contrasenaEncriptada);

		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		return repositorio.buscarPorId(idUsuario).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public Usuario autenticar(String correo, String contrasenaPlana) {
		Usuario usuario = repositorio.buscarPorCorreo(correo)
				.orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(HttpStatus.UNAUTHORIZED,
						"Credenciales invalidas"));

		if (!BCrypt.checkpw(contrasenaPlana, usuario.getContrasenaHash())) {
			throw new org.springframework.web.server.ResponseStatusException(HttpStatus.UNAUTHORIZED,
					"Credenciales invalidas");
		}

		if (!usuario.isEstadoUsuario()) {
			throw new org.springframework.web.server.ResponseStatusException(HttpStatus.FORBIDDEN,
					"El usuario se encuentra inactivo. Contacte al administrador.");
		}

		return usuario;
	}

	@Override
	public List<Usuario> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idUsuario) {
		repositorio.eliminar(idUsuario);
	}
}
