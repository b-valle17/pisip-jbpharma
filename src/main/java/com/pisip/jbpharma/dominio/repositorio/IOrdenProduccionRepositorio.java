package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;

public interface IOrdenProduccionRepositorio {

	OrdenProduccion guardar(OrdenProduccion nuevaOrdenProduccion);
	
	Optional<OrdenProduccion>buscarPorId(int idOrden);
	
	Optional<OrdenProduccion> buscarPorNumeroLote(String numeroLote);
	
	List<OrdenProduccion> buscarPorEstado(String estado);
	
	List<OrdenProduccion> listarTodos();
	
	void eliminar(int idOrdenProduccion);

}
