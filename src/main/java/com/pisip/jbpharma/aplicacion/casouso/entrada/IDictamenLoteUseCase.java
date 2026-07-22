package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.presentacion.dto.response.DictamenLoteResponseDto;

public interface IDictamenLoteUseCase {

	DictamenLote guardar(DictamenLote nuevoDictamen);

	DictamenLote buscarPorId(int idDictamen);

	List<DictamenLote> listarTodos();

	void eliminar(int idDictamen);

	/** Arma la respuesta del dictamen incluyendo los datos del ensayo de laboratorio asociado al lote. */
	DictamenLoteResponseDto buscarConEnsayo(int idDictamen);

	/** Marca el dictamen como ACEPTADO. */
	DictamenLote aceptar(int idDictamen);

	/** Marca el dictamen como RECHAZADO. Requiere un motivo/observacion. */
	DictamenLote rechazar(int idDictamen, String motivoRechazo);

	/** Busca el dictamen mas reciente de una orden de produccion (lote). Vacio si el lote aun no tiene dictamen. */
	Optional<DictamenLote> buscarPorOrdenProduccion(int idOrdenProduccion);
}
