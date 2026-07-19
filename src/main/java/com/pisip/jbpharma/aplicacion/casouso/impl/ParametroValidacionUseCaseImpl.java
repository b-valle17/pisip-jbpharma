package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.iParametroValidacionUseCase;
import com.pisip.jbpharma.dominio.entidades.ParametroValidacion;
import com.pisip.jbpharma.dominio.repositorio.iParametroValidacionRepositorio;

public class ParametroValidacionUseCaseImpl implements iParametroValidacionUseCase{
	
	private final iParametroValidacionRepositorio repositorio;

	public ParametroValidacionUseCaseImpl(iParametroValidacionRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}
	
	@Override
	public ParametroValidacion guardar(ParametroValidacion nuevoParametroValidacion) {
		// Justo aqui se aplican las reglas de negocio
		return repositorio.guardar(nuevoParametroValidacion);
	}

	@Override
	public ParametroValidacion buscarPorId(int idParametroValidacion) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idParametroValidacion).orElseThrow(()->new RuntimeException("Parametro de validacion no encontrado"));
	}

	@Override
	public List<ParametroValidacion> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idParametroValidacion) {
		repositorio.eliminar(idParametroValidacion);
		
	}


}
