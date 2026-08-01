package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IInformeAuditoriaUseCase;
import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;
import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;
import com.pisip.jbpharma.dominio.repositorio.IAuditoriaLoteRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IInformeAuditoriaRepositorio;

public class InformeAuditoriaUseCaseImpl implements IInformeAuditoriaUseCase {

	private final IInformeAuditoriaRepositorio repositorio;
	private final IAuditoriaLoteRepositorio auditoriaLoteRepositorio;

	public InformeAuditoriaUseCaseImpl(IInformeAuditoriaRepositorio repositorio,
			IAuditoriaLoteRepositorio auditoriaLoteRepositorio) {
		this.repositorio = repositorio;
		this.auditoriaLoteRepositorio = auditoriaLoteRepositorio;
	}

	@Override
	public InformeAuditoria guardar(InformeAuditoria nuevoInforme) {
		AuditoriaLote auditoria = auditoriaLoteRepositorio.buscarPorId(nuevoInforme.getIdAuditoria())
				.orElseThrow(() -> new IllegalArgumentException(
						"Auditoria de lote no encontrada con id: " + nuevoInforme.getIdAuditoria()));

		nuevoInforme.setFechaGeneracion(new java.util.Date());
		if (nuevoInforme.getFormato() == null || nuevoInforme.getFormato().isBlank()) {
			nuevoInforme.setFormato("PDF");
		}
		nuevoInforme.setRutaArchivo(String.format("informes/informe-auditoria-lote%d-%d.%s",
				auditoria.getIdOrdenProduccion(), System.currentTimeMillis(),
				nuevoInforme.getFormato().toLowerCase()));
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

	@Override
	public InformeAuditoria comentar(int idInforme, String comentario) {
		InformeAuditoria informe = buscarPorId(idInforme);
		informe.setComentario(comentario);
		return repositorio.guardar(informe);
	}
}
