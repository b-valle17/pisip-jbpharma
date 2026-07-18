package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IAuditoriaLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;
import com.pisip.jbpharma.dominio.repositorio.IAuditoriaLoteRepositorio;

public class AuditoriaLoteUseCaseImpl implements IAuditoriaLoteUseCase {

	private final IAuditoriaLoteRepositorio repositorio;

	public AuditoriaLoteUseCaseImpl(IAuditoriaLoteRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public AuditoriaLote guardar(AuditoriaLote nuevaAuditoriaLote) {
		return repositorio.guardar(nuevaAuditoriaLote);
	}

	@Override
	public AuditoriaLote buscarPorId(int idAuditoria) {
		return repositorio.buscarPorId(idAuditoria).orElseThrow(() -> new RuntimeException("Auditoria de lote no encontrada"));
	}

	@Override
	public List<AuditoriaLote> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idAuditoria) {
		repositorio.eliminar(idAuditoria);
	}

	@Override
	public AuditoriaLote actualizar(int id, AuditoriaLote auditoriaLoteDatos) {
		buscarPorId(id);
		auditoriaLoteDatos.setIdAuditoria(id);
		return repositorio.guardar(auditoriaLoteDatos);
	}
}
