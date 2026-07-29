package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IOrdenProduccionRepositorio;

public class EnsayoLaboratorioUseCaseImpl implements iEnsayoLaboratorioUseCase {
	private final iEnsayoLaboratorioRepositorio repositorio;
	private final IOrdenProduccionRepositorio ordenRepositorio;

	public EnsayoLaboratorioUseCaseImpl(iEnsayoLaboratorioRepositorio repositorio, IOrdenProduccionRepositorio ordenRepositorio) {
		this.repositorio = repositorio;
		this.ordenRepositorio = ordenRepositorio;
	}

	@Override
	public EnsayoLaboratorio guardar(EnsayoLaboratorio nuevo) {
		// El ID lo genera PostgreSQL/JPA.
		nuevo.setIdEnsayo(null);
		if (nuevo.getCreadoEn() == null)
			nuevo.setCreadoEn(LocalDateTime.now());
		if (nuevo.getFechaEnsayo() == null)
			nuevo.setFechaEnsayo(LocalDateTime.now());

		// El producto siempre se obtiene de la orden; nunca se confía en el valor enviado por la vista.
		if (nuevo.getIdOrden() == null) throw new IllegalArgumentException("Debe seleccionar una orden de producción.");
		var orden = ordenRepositorio.buscarPorId(nuevo.getIdOrden())
				.orElseThrow(() -> new IllegalArgumentException("Orden de producción no encontrada."));
		nuevo.setIdProducto(orden.getIdProducto());

		// Código temporal de máximo 30 caracteres para respetar VARCHAR(30).
		nuevo.setCodigoEnsayo("TEMP-" + UUID.randomUUID().toString().replace("-", "").substring(0, 20));
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
		// El código y el responsable se conservan; el producto se recalcula desde la orden.
		datos.setCodigoEnsayo(actual.getCodigoEnsayo());
		datos.setResponsable(actual.getResponsable());
		if (datos.getIdOrden() == null) throw new IllegalArgumentException("Debe seleccionar una orden de producción.");
		var orden = ordenRepositorio.buscarPorId(datos.getIdOrden())
				.orElseThrow(() -> new IllegalArgumentException("Orden de producción no encontrada."));
		datos.setIdProducto(orden.getIdProducto());
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
