package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;
import com.pisip.jbpharma.presentacion.dto.response.IndicadorKpiResumenDto;

public interface IIndicadorKpiUseCase {

	IndicadorKpi guardar(IndicadorKpi nuevoIndicador);

	IndicadorKpi buscarPorId(int idKpi);

	List<IndicadorKpi> listarTodos();

	void eliminar(int idKpi);

	/** Calcula las metricas agregadas para el dashboard de KPIs (SmallBox/InfoBox). */
	IndicadorKpiResumenDto calcularResumen();
}
