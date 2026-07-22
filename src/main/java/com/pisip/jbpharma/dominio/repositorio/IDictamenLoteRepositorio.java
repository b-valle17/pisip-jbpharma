package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;

public interface IDictamenLoteRepositorio {

	DictamenLote guardar(DictamenLote nuevoDictamen);

	Optional<DictamenLote> buscarPorId(int idDictamen);

	List<DictamenLote> listarTodos();

	void eliminar(int idDictamen);

	/** Busca el dictamen mas reciente asociado a una orden de produccion (lote) especifica. */
	Optional<DictamenLote> buscarPorIdOrdenProduccion(int idOrdenProduccion);
}
