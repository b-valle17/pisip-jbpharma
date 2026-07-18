package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IDictamenLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.dominio.repositorio.IDictamenLoteRepositorio;

public class DictamenLoteUseCaseImpl implements IDictamenLoteUseCase {

	private final IDictamenLoteRepositorio repositorio;

	public DictamenLoteUseCaseImpl(IDictamenLoteRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public DictamenLote guardar(DictamenLote nuevoDictamenLote) {
		return repositorio.guardar(nuevoDictamenLote);
	}

	@Override
	public DictamenLote buscarPorId(int idDictamen) {
		return repositorio.buscarPorId(idDictamen).orElseThrow(() -> new RuntimeException("Dictamen de lote no encontrado"));
	}

	@Override
	public List<DictamenLote> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idDictamen) {
		repositorio.eliminar(idDictamen);
	}

	@Override
	public DictamenLote actualizar(int id, DictamenLote dictamenLoteDatos) {
		buscarPorId(id);
		dictamenLoteDatos.setIdDictamen(id);
		return repositorio.guardar(dictamenLoteDatos);
	}
}
