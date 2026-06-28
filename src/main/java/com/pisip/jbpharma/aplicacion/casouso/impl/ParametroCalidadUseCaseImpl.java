package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IParametroCalidadUseCase;
import com.pisip.jbpharma.dominio.entidades.ParametroCalidad;
import com.pisip.jbpharma.dominio.repositorio.IParametroCalidadRepositorio;

public class ParametroCalidadUseCaseImpl implements IParametroCalidadUseCase {

	private final IParametroCalidadRepositorio repositorio;

	public ParametroCalidadUseCaseImpl(IParametroCalidadRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public ParametroCalidad guardar(ParametroCalidad nuevoParametro) {
		return repositorio.guardar(nuevoParametro);
	}

	@Override
	public ParametroCalidad buscarPorId(int idParametro) {
		return repositorio.buscarPorId(idParametro).orElseThrow(() -> new RuntimeException("Parametro no encontrado"));
	}

	@Override
	public List<ParametroCalidad> listarTodos() {
		return repositorio.listarTodos();
	}
	
	@Override
	public ParametroCalidad actualizar(int idParametro, ParametroCalidad parametroCalidad) {
	    this.buscarPorId(idParametro);
	    parametroCalidad.setIdParametro(idParametro); 
	    return repositorio.guardar(parametroCalidad);
	}

	@Override
	public void eliminar(int idParametro) {
		repositorio.eliminar(idParametro);
	}
}