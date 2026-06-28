package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.iUsuarioUseCase;
import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.dominio.repositorio.iUsuarioRepositorio;

public class UsuarioUseCaseImpl implements iUsuarioUseCase{
	
	private final iUsuarioRepositorio repositorio;
	

	public UsuarioUseCaseImpl(iUsuarioRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {
		// Justo aqui se aplican las reglas de negocio
		return repositorio.guardar(nuevoUsuario);
	}

	@Override
	public Usuario buscarPorId(int idUsuario) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idUsuario).orElseThrow(()->new RuntimeException("Usuario no encontrado"));
	}

	@Override
	public List<Usuario> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idUsuario) {
		repositorio.eliminar(idUsuario);
		
	}


}
