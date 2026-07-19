package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;

public interface IIndicadorKpiRepositorio {

	IndicadorKpi guardar(IndicadorKpi nuevoIndicador);

	Optional<IndicadorKpi> buscarPorId(int idKpi);

	List<IndicadorKpi> listarTodos();

	void eliminar(int idKpi);
}
