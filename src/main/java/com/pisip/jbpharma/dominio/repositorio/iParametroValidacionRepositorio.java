package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.ParametroValidacion;

public interface iParametroValidacionRepositorio {
	
	ParametroValidacion guardar(ParametroValidacion nuevoParametroValidacion);
	Optional<ParametroValidacion> buscarPorId(int idParametroValidacion);
	List<ParametroValidacion> listarTodos();
	void eliminar(int idParametroValidacion);

}
