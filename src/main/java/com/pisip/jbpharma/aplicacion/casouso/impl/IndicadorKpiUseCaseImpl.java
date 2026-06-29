package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IIndicadorKpiUseCase;
import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;
import com.pisip.jbpharma.dominio.repositorio.IIndicadorKpiRepositorio;

public class IndicadorKpiUseCaseImpl implements IIndicadorKpiUseCase {

	private final IIndicadorKpiRepositorio repositorio;

	public IndicadorKpiUseCaseImpl(IIndicadorKpiRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public IndicadorKpi guardar(IndicadorKpi nuevoIndicador) {
		return repositorio.guardar(nuevoIndicador);
	}

	@Override
	public IndicadorKpi buscarPorId(int idKpi) {
		return repositorio.buscarPorId(idKpi)
				.orElseThrow(() -> new RuntimeException("Indicador KPI no encontrado con id: " + idKpi));
	}

	@Override
	public List<IndicadorKpi> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idKpi) {
		repositorio.eliminar(idKpi);
	}
}
