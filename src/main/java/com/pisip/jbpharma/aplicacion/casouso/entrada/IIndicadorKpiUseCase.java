package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;

public interface IIndicadorKpiUseCase {

	IndicadorKpi guardar(IndicadorKpi nuevoIndicador);

	IndicadorKpi buscarPorId(int idKpi);

	List<IndicadorKpi> listarTodos();

	void eliminar(int idKpi);
}
