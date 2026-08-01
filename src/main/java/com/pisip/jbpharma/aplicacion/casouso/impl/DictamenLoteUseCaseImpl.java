package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IDictamenLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.entidades.HistorialLote;
import com.pisip.jbpharma.dominio.repositorio.IDictamenLoteRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IHistorialLoteRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.presentacion.dto.response.DictamenLoteResponseDto;

public class DictamenLoteUseCaseImpl implements IDictamenLoteUseCase {

	public static final String ESTADO_PENDIENTE = "PENDIENTE";
	public static final String ESTADO_ACEPTADO = "ACEPTADO";
	public static final String ESTADO_RECHAZADO = "RECHAZADO";

	private final IDictamenLoteRepositorio repositorio;
	private final iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio;
	private final IHistorialLoteRepositorio historialLoteRepositorio;

	public DictamenLoteUseCaseImpl(IDictamenLoteRepositorio repositorio,
			iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio,
			IHistorialLoteRepositorio historialLoteRepositorio) {
		this.repositorio = repositorio;
		this.ensayoLaboratorioRepositorio = ensayoLaboratorioRepositorio;
		this.historialLoteRepositorio = historialLoteRepositorio;
	}

	@Override
	public DictamenLote guardar(DictamenLote nuevoDictamen) {
		boolean esNuevo = nuevoDictamen.getIdDictamen() == null;
		if (esNuevo) {
			nuevoDictamen.setEstado(ESTADO_PENDIENTE);
			if (nuevoDictamen.getObservaciones() == null) {
				nuevoDictamen.setObservaciones("");
			}
		}
		DictamenLote guardado = repositorio.guardar(nuevoDictamen);
		if (esNuevo) {
			historialLoteRepositorio.guardar(construirHistorial(guardado, "REGISTRO",
					"Dictamen registrado y pendiente de revision del supervisor."));
		}
		return guardado;
	}

	@Override
	public DictamenLote buscarPorId(int idDictamen) {
		return repositorio.buscarPorId(idDictamen)
				.orElseThrow(() -> new RuntimeException("Dictamen de lote no encontrado con id: " + idDictamen));
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
	public DictamenLoteResponseDto buscarConEnsayo(int idDictamen) {
		DictamenLote dictamen = buscarPorId(idDictamen);
		return construirRespuestaConEnsayo(dictamen);
	}

	@Override
	public DictamenLote aceptar(int idDictamen) {
		DictamenLote dictamen = buscarPorId(idDictamen);
		dictamen.setEstado(ESTADO_ACEPTADO);
		DictamenLote actualizado = repositorio.guardar(dictamen);
		historialLoteRepositorio.guardar(construirHistorial(actualizado, "ACEPTACION",
				"El lote fue aceptado por el supervisor."));
		return actualizado;
	}

	@Override
	public DictamenLote rechazar(int idDictamen, String motivoRechazo) {
		DictamenLote dictamen = buscarPorId(idDictamen);
		dictamen.setEstado(ESTADO_RECHAZADO);
		if (motivoRechazo != null && !motivoRechazo.isBlank()) {
			dictamen.setObservaciones(motivoRechazo);
		}
		DictamenLote actualizado = repositorio.guardar(dictamen);
		historialLoteRepositorio.guardar(construirHistorial(actualizado, "RECHAZO",
				"El lote fue rechazado por el supervisor: " + actualizado.getObservaciones()));
		return actualizado;
	}

	@Override
	public Optional<DictamenLote> buscarPorOrdenProduccion(int idOrdenProduccion) {
		return repositorio.buscarPorIdOrdenProduccion(idOrdenProduccion);
	}

	@Override
	public List<EnsayoLaboratorio> listarEnsayosPendientesDictamen() {
		return ensayoLaboratorioRepositorio.listarTodos().stream()
				.filter(ensayo -> ensayo.getIdOrden() != null)
				.filter(ensayo -> repositorio.buscarPorIdOrdenProduccion(ensayo.getIdOrden()).isEmpty())
				.toList();
	}

	private HistorialLote construirHistorial(DictamenLote dictamen, String accion, String descripcion) {
		HistorialLote historial = new HistorialLote();
		historial.setIdOrdenProduccion(dictamen.getIdOrdenProduccion());
		historial.setFechaEvento(new java.sql.Date(System.currentTimeMillis()));
		historial.setAccion(accion);
		historial.setDescripcion(descripcion);
		return historial;
	}

	/** Arma el DTO de respuesta uniendo el dictamen con el ultimo ensayo de laboratorio del mismo lote. */
	private DictamenLoteResponseDto construirRespuestaConEnsayo(DictamenLote dictamen) {
		DictamenLoteResponseDto dto = new DictamenLoteResponseDto();
		dto.setIdDictamen(dictamen.getIdDictamen());
		dto.setIdOrdenProduccion(dictamen.getIdOrdenProduccion());
		dto.setIdUsuarioInspector(dictamen.getIdUsuarioInspector());
		dto.setFechaDictamen(dictamen.getFechaDictamen());
		dto.setEstado(dictamen.getEstado());
		dto.setObservaciones(dictamen.getObservaciones());

		Optional<EnsayoLaboratorio> ensayo = ensayoLaboratorioRepositorio.buscarPorIdOrden(dictamen.getIdOrdenProduccion());
		ensayo.ifPresent(e -> {
			dto.setIdEnsayo(e.getIdEnsayo());
			dto.setCodigoEnsayo(e.getCodigoEnsayo());
			dto.setEstadoEnsayo(e.getEstado());
			dto.setObservacionEnsayo(e.getObservacion());
		});

		return dto;
	}
}
