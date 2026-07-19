package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.HistorialLote;

public interface IHistorialLoteUseCase {

	HistorialLote guardar(HistorialLote nuevoHistorial);

	HistorialLote buscarPorId(int idHistorial);

	List<HistorialLote> listarTodos();

	void eliminar(int idHistorial);
}
