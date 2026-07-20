package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IHistorialLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.HistorialLote;
import com.pisip.jbpharma.dominio.repositorio.IHistorialLoteRepositorio;

public class HistorialLoteUseCaseImpl implements IHistorialLoteUseCase {

	private final IHistorialLoteRepositorio repositorio;

	public HistorialLoteUseCaseImpl(IHistorialLoteRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public HistorialLote guardar(HistorialLote nuevoHistorial) {
		return repositorio.guardar(nuevoHistorial);
	}

	@Override
	public HistorialLote buscarPorId(int idHistorial) {
		return repositorio.buscarPorId(idHistorial)
				.orElseThrow(() -> new RuntimeException("Historial de lote no encontrado con id: " + idHistorial));
	}

	@Override
	public List<HistorialLote> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idHistorial) {
		repositorio.eliminar(idHistorial);
	}
}
