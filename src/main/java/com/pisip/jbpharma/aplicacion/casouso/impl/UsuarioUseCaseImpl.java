package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IUsuarioUseCase;
import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.dominio.repositorio.IUsuarioRepositorio;

public class UsuarioUseCaseImpl implements IUsuarioUseCase {

	private final IUsuarioRepositorio repositorio;
	private final PasswordEncoder passwordEncoder;

	public UsuarioUseCaseImpl(IUsuarioRepositorio repositorio, PasswordEncoder passwordEncoder) {
		this.repositorio = repositorio;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {
		String contrasenaEncriptada = passwordEncoder.encode(nuevoUsuario.getContrasenaHash());
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
				.orElseThrow(() -> new RuntimeException("Credenciales invalidas"));
		if (!passwordEncoder.matches(contrasenaPlana, usuario.getContrasenaHash())) {
			throw new RuntimeException("Credenciales invalidas");
		}
		if (!usuario.isEstadoUsuario()) {
			throw new RuntimeException("El usuario se encuentra inactivo. Contacte al administrador.");
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