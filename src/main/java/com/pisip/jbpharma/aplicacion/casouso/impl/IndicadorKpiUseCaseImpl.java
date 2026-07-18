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
	public IndicadorKpi guardar(IndicadorKpi nuevoIndicadorKpi) {
		return repositorio.guardar(nuevoIndicadorKpi);
	}

	@Override
	public IndicadorKpi buscarPorId(int idKpi) {
		return repositorio.buscarPorId(idKpi).orElseThrow(() -> new RuntimeException("Indicador KPI no encontrado"));
	}

	@Override
	public List<IndicadorKpi> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idKpi) {
		repositorio.eliminar(idKpi);
	}

	@Override
	public IndicadorKpi actualizar(int id, IndicadorKpi indicadorKpiDatos) {
		buscarPorId(id);
		indicadorKpiDatos.setIdKpi(id);
		return repositorio.guardar(indicadorKpiDatos);
	}
}
