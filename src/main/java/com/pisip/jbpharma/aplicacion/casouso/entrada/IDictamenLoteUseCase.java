package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;

public interface IDictamenLoteUseCase {

	DictamenLote guardar(DictamenLote nuevoDictamenLote);

	DictamenLote buscarPorId(int idDictamen);

	List<DictamenLote> listarTodos();

	DictamenLote actualizar(int id, DictamenLote dictamenLote);

	void eliminar(int idDictamen);
}
