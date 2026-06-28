package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.ParametroValidacion;

public interface iParametroValidacionUseCase {

	ParametroValidacion guardar(ParametroValidacion nuevoParametroValidacion);
	ParametroValidacion buscarPorId(int idParametroValidacion);
		List<ParametroValidacion> listarTodos();
		void eliminar(int idParametroValidacion);
	

}
