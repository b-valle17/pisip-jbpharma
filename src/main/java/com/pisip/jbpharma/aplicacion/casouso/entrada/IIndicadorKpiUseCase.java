package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;

public interface IIndicadorKpiUseCase {

	IndicadorKpi guardar(IndicadorKpi nuevoIndicadorKpi);

	IndicadorKpi buscarPorId(int idKpi);

	List<IndicadorKpi> listarTodos();

	IndicadorKpi actualizar(int id, IndicadorKpi indicadorKpi);

	void eliminar(int idKpi);
}
