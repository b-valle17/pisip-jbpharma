package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IOrdenProduccionUseCase;
import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;
import com.pisip.jbpharma.dominio.repositorio.IOrdenProduccionRepositorio;

public class OrdenProduccionUseCaseImpl implements IOrdenProduccionUseCase {
	
	private final IOrdenProduccionRepositorio repositorio;
	
	public OrdenProduccionUseCaseImpl(IOrdenProduccionRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public OrdenProduccion guardar(OrdenProduccion nuevaOrdenProduccion) {
		return repositorio.guardar(nuevaOrdenProduccion);
	}

	@Override
	public OrdenProduccion buscarPorId(int idOrden) {
		return repositorio.buscarPorId(idOrden).orElseThrow(() -> new RuntimeException("Orden no encontrada"));
	}

	@Override
	public OrdenProduccion buscarPorNumeroLote(String numeroLote) {
		return repositorio.buscarPorNumeroLote(numeroLote).orElseThrow(() -> new RuntimeException("Numero de Lote no encontrado"));
	}

	@Override
	public List<OrdenProduccion> buscarPorEstado(String estado) {
		return repositorio.buscarPorEstado(estado);
	}

	@Override
	public List<OrdenProduccion> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idOrdenProduccion) {
		repositorio.eliminar(idOrdenProduccion);		
	}

}
