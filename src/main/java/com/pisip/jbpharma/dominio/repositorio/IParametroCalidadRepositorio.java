package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.ParametroCalidad;

public interface IParametroCalidadRepositorio {

	ParametroCalidad guardar(ParametroCalidad nuevoParametro);

	Optional<ParametroCalidad> buscarPorId(int idParametro);

	List<ParametroCalidad> listarTodos();

	void eliminar(int idParametro);
}