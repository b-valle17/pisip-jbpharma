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
	public InformeAuditoria guardar(InformeAuditoria nuevoInformeAuditoria) {
		return repositorio.guardar(nuevoInformeAuditoria);
	}

	@Override
	public InformeAuditoria buscarPorId(int idInforme) {
		return repositorio.buscarPorId(idInforme).orElseThrow(() -> new RuntimeException("Informe de auditoria no encontrado"));
	}

	@Override
	public List<InformeAuditoria> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idInforme) {
		repositorio.eliminar(idInforme);
	}

	@Override
	public InformeAuditoria actualizar(int id, InformeAuditoria informeAuditoriaDatos) {
		buscarPorId(id);
		informeAuditoriaDatos.setIdInforme(id);
		return repositorio.guardar(informeAuditoriaDatos);
	}
}
