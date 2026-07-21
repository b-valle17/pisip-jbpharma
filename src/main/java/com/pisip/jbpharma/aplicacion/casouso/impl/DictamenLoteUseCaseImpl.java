package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IDictamenLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.repositorio.IDictamenLoteRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.presentacion.dto.response.DictamenLoteResponseDto;

public class DictamenLoteUseCaseImpl implements IDictamenLoteUseCase {

	public static final String ESTADO_ACEPTADO = "ACEPTADO";
	public static final String ESTADO_RECHAZADO = "RECHAZADO";

	private final IDictamenLoteRepositorio repositorio;
	private final iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio;

	public DictamenLoteUseCaseImpl(IDictamenLoteRepositorio repositorio,
			iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio) {
		this.repositorio = repositorio;
		this.ensayoLaboratorioRepositorio = ensayoLaboratorioRepositorio;
	}

	@Override
	public DictamenLote guardar(DictamenLote nuevoDictamen) {
		return repositorio.guardar(nuevoDictamen);
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
		return repositorio.guardar(dictamen);
	}

	@Override
	public DictamenLote rechazar(int idDictamen, String motivoRechazo) {
		DictamenLote dictamen = buscarPorId(idDictamen);
		dictamen.setEstado(ESTADO_RECHAZADO);
		if (motivoRechazo != null && !motivoRechazo.isBlank()) {
			dictamen.setObservaciones(motivoRechazo);
		}
		return repositorio.guardar(dictamen);
	}

	@Override
	public Optional<DictamenLote> buscarPorOrdenProduccion(int idOrdenProduccion) {
		return repositorio.buscarPorIdOrdenProduccion(idOrdenProduccion);
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
