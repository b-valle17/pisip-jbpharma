package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.ParametroCalidad;

public interface IParametroCalidadUseCase {

	ParametroCalidad guardar(ParametroCalidad nuevoParametro);

	ParametroCalidad buscarPorId(int idParametro);

	List<ParametroCalidad> listarTodos();
	
	ParametroCalidad actualizar(int idParametro, ParametroCalidad parametroCalidad);

	void eliminar(int idParametro);
}