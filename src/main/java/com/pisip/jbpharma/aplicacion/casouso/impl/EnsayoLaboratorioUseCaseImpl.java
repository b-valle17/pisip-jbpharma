package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;

public class EnsayoLaboratorioUseCaseImpl implements iEnsayoLaboratorioUseCase {
	private final iEnsayoLaboratorioRepositorio repositorio;

	public EnsayoLaboratorioUseCaseImpl(iEnsayoLaboratorioRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public EnsayoLaboratorio guardar(EnsayoLaboratorio nuevo) {
		// El ID lo genera PostgreSQL/JPA.
		nuevo.setIdEnsayo(null);
		if (nuevo.getCreadoEn() == null)
			nuevo.setCreadoEn(LocalDateTime.now());
		if (nuevo.getFechaEnsayo() == null)
			nuevo.setFechaEnsayo(LocalDateTime.now());

		// Se guarda primero con un código temporal único para obtener el ID.
		nuevo.setCodigoEnsayo("TEMP-" + UUID.randomUUID());
		EnsayoLaboratorio guardado = repositorio.guardar(nuevo);

		String codigo = String.format(
				"ENS-%d-%03d",
				guardado.getFechaEnsayo().getYear(),
				guardado.getIdEnsayo());
		guardado.setCodigoEnsayo(codigo);

		return repositorio.guardar(guardado);
	}

	@Override
	public EnsayoLaboratorio buscarPorId(long id) {
		return repositorio.buscarPorId(id)
				.orElseThrow(() -> new RuntimeException("Ensayo de laboratorio no encontrado"));
	}

	@Override
	public List<EnsayoLaboratorio> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public EnsayoLaboratorio actualizar(long id, EnsayoLaboratorio datos) {
		EnsayoLaboratorio actual = buscarPorId(id);
		datos.setIdEnsayo(id);
		// El código se conserva y no puede modificarse manualmente.
		datos.setCodigoEnsayo(actual.getCodigoEnsayo());
		if (datos.getCreadoEn() == null)
			datos.setCreadoEn(actual.getCreadoEn());
		return repositorio.guardar(datos);
	}

	@Override
	public void eliminar(long id) {
		buscarPorId(id);
		repositorio.eliminar(id);
	}

	@Override
	public List<EnsayoLaboratorio> buscar(String texto) {
		String c = texto == null ? "" : texto.trim().toLowerCase();
		return listarTodos().stream()
				.filter(e -> (e.getCodigoEnsayo() != null && e.getCodigoEnsayo().toLowerCase().contains(c))
						|| (e.getResponsable() != null && e.getResponsable().toLowerCase().contains(c))
						|| (e.getEstado() != null && e.getEstado().toLowerCase().contains(c)))
				.toList();
	}
}
