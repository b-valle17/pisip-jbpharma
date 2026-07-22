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
		// 1. VALIDACIÓN PARA REGISTRO NUEVO (idUsuario == 0)
		if (nuevoUsuario.getIdUsuario() == 0 && repositorio.buscarPorCorreo(nuevoUsuario.getCorreo()).isPresent()) {
			throw new IllegalArgumentException("El correo electrónico ya se encuentra registrado.");
		}

		// 2. VALIDACIÓN PARA EDICIÓN DE USUARIO EXISTENTE
		if (nuevoUsuario.getIdUsuario() > 0) {
			Optional<Usuario> existente = repositorio.buscarPorCorreo(nuevoUsuario.getCorreo());
			if (existente.isPresent() && existente.get().getIdUsuario() != nuevoUsuario.getIdUsuario()) {
				throw new IllegalArgumentException("El correo ya está en uso por otro usuario.");
			}
		}

		// 3. ENCRIPTACIÓN SEGURA DE CONTRASEÑA
		// Verificamos prefijos estándar de BCrypt ($2a$, $2b$, $2y$)
		String pass = nuevoUsuario.getContrasenaHash();
		if (pass != null && !pass.trim().isEmpty()) {
			boolean yaEstaEncriptada = pass.startsWith("$2a$") || pass.startsWith("$2b$") || pass.startsWith("$2y$");
			if (!yaEstaEncriptada) {
				String contrasenaEncriptada = BCrypt.hashpw(pass, BCrypt.gensalt());
				nuevoUsuario.setContrasenaHash(contrasenaEncriptada);
			}
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