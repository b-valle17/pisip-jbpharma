package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IInformeAuditoriaUseCase;
import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;
import com.pisip.jbpharma.dominio.repositorio.IInformeAuditoriaRepositorio;

public class InformeAuditoriaUseCaseImpl implements IInformeAuditoriaUseCase {

	private final IInformeAuditoriaRepositorio repositorio;

	public InformeAuditoriaUseCaseImpl(IInformeAuditoriaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public InformeAuditoria guardar(InformeAuditoria nuevoInforme) {
		return repositorio.guardar(nuevoInforme);
	}

	@Override
	public InformeAuditoria buscarPorId(int idInforme) {
		return repositorio.buscarPorId(idInforme)
				.orElseThrow(() -> new RuntimeException("Informe de auditoria no encontrado con id: " + idInforme));
	}

	@Override
	public List<InformeAuditoria> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idInforme) {
		repositorio.eliminar(idInforme);
	}
}
