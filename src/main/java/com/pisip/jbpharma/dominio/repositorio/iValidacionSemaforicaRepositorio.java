package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;

public interface iValidacionSemaforicaRepositorio {
	
	ValidacionSemaforica guardar(ValidacionSemaforica nuevaValidacionSemaforica);
	Optional<ValidacionSemaforica> buscarPorId(int idValidacionSemaforica);
	List<ValidacionSemaforica> listarTodos();
	void eliminar(int idValidacionSemaforica);

}
