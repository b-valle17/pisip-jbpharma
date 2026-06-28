package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoVariableUseCase;
import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoVariableRepositorio;

public class EnsayoVariableUseCaseImpl implements iEnsayoVariableUseCase {
	

	private final iEnsayoVariableRepositorio repositorio;

	public EnsayoVariableUseCaseImpl(iEnsayoVariableRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}
	
	@Override
	public EnsayoVariable guardar(EnsayoVariable nuevoEnsayoVariable) {
		// Justo aqui se aplican las reglas de negocio
		return repositorio.guardar(nuevoEnsayoVariable);
	}

	@Override
	public EnsayoVariable buscarPorId(int idEnsayoVariable) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idEnsayoVariable).orElseThrow(()->new RuntimeException("Ensayo de variable no encontrado"));
	}

	@Override
	public List<EnsayoVariable> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEnsayoVariable) {
		repositorio.eliminar(idEnsayoVariable);
		
	}
}
