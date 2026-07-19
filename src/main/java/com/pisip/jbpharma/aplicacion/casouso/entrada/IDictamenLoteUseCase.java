package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;

public interface IDictamenLoteUseCase {

	DictamenLote guardar(DictamenLote nuevoDictamen);

	DictamenLote buscarPorId(int idDictamen);

	List<DictamenLote> listarTodos();

	void eliminar(int idDictamen);
}
