package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;

public interface IOrdenProduccionUseCase {

	OrdenProduccion guardar(OrdenProduccion nuevaOrdenProduccion);
	
	OrdenProduccion buscarPorId(int idOrden);
	
	OrdenProduccion  buscarPorNumeroLote(String numeroLote);
	
	List<OrdenProduccion> buscarPorEstado(String estado);
	
	List<OrdenProduccion> listarTodos();
	
	void eliminar(int idOrdenProduccion);
	
	OrdenProduccion actualizar(Integer idOrden, OrdenProduccion ordenProduccion);
}
