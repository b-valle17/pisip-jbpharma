package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IRolUseCase;
import com.pisip.jbpharma.dominio.entidades.Rol;
import com.pisip.jbpharma.dominio.repositorio.IRolRepositorio;

public class RolUseCaseImpl implements IRolUseCase {

	private final IRolRepositorio repositorio;

	public RolUseCaseImpl(IRolRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Rol guardar(Rol nuevoRol) {
		return repositorio.guardar(nuevoRol);
	}

	@Override
	public Rol buscarPorId(int idRol) {
		return repositorio.buscarPorId(idRol).orElseThrow(() -> new RuntimeException("Rol no encontrado"));
	}

	@Override
	public List<Rol> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idRol) {
		repositorio.eliminar(idRol);
	}
}