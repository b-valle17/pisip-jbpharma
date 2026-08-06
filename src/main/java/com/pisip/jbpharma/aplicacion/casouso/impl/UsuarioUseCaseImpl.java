package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

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

		if (nuevoUsuario == null) {
			throw new IllegalArgumentException(
					"Los datos del usuario son obligatorios.");
		}

		Integer idUsuario = nuevoUsuario.getIdUsuario();

		if (nuevoUsuario.getCorreo() == null
				|| nuevoUsuario.getCorreo().trim().isEmpty()) {
			throw new IllegalArgumentException(
					"El correo electrónico es obligatorio.");
		}

		nuevoUsuario.setCorreo(
				nuevoUsuario.getCorreo().trim().toLowerCase()
		);

		Optional<Usuario> existente =
				repositorio.buscarPorCorreo(nuevoUsuario.getCorreo());

		// Registro nuevo: el ID todavía es null
		if (idUsuario == null || idUsuario == 0) {

			if (existente.isPresent()) {
				throw new IllegalArgumentException(
						"El correo electrónico ya se encuentra registrado.");
			}

		// Edición: el ID ya existe
		} else {

			if (existente.isPresent()
					&& !existente.get()
							.getIdUsuario()
							.equals(idUsuario)) {

				throw new IllegalArgumentException(
						"El correo ya está en uso por otro usuario.");
			}
		}

		String pass = nuevoUsuario.getContrasenaHash();

		if (pass == null || pass.trim().isEmpty()) {
			throw new IllegalArgumentException(
					"La contraseña es obligatoria.");
		}

		boolean yaEstaEncriptada =
				pass.startsWith("$2a$")
				|| pass.startsWith("$2b$")
				|| pass.startsWith("$2y$");

		if (!yaEstaEncriptada) {
			nuevoUsuario.setContrasenaHash(
					BCrypt.hashpw(pass, BCrypt.gensalt())
			);
		}

		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario actualizar(int id, Usuario usuario) {
		// 1. Aseguramos que el usuario existe antes de actualizar
		Usuario usuarioExistente = buscarPorId(id);
		usuario.setIdUsuario(id);

		// 2. Si la contraseña viene nula o vacía en el DTO de edición,
		// reasignamos la contraseña que ya tiene almacenada en BD.
		if (usuario.getContrasenaHash() == null || usuario.getContrasenaHash().trim().isEmpty()) {
			usuario.setContrasenaHash(usuarioExistente.getContrasenaHash());
		}

		return guardar(usuario); // Reutiliza validaciones y encriptación de guardar()
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		return repositorio.buscarPorId(idUsuario)
				.orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(HttpStatus.NOT_FOUND,
						"Usuario no encontrado con ID: " + idUsuario));
	}

	@Override
	public Usuario autenticar(String correo, String contrasenaPlana) {
		Usuario usuario = repositorio.buscarPorCorreo(correo)
				.orElseThrow(() -> new org.springframework.web.server.ResponseStatusException(HttpStatus.UNAUTHORIZED,
						"Credenciales inválidas"));

		if (!BCrypt.checkpw(contrasenaPlana, usuario.getContrasenaHash())) {
			throw new org.springframework.web.server.ResponseStatusException(HttpStatus.UNAUTHORIZED,
					"Credenciales inválidas");
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
		buscarPorId(idUsuario);
		repositorio.eliminar(idUsuario);
	}

	@Override
	public boolean existePorCorreo(String correo) {
		return repositorio.buscarPorCorreo(correo).isPresent();
	}
}
