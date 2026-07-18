package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.HistorialLote;

public interface IHistorialLoteUseCase {

	HistorialLote guardar(HistorialLote nuevoHistorialLote);

	HistorialLote buscarPorId(int idHistorial);

	List<HistorialLote> listarTodos();

	HistorialLote actualizar(int id, HistorialLote historialLote);

	void eliminar(int idHistorial);
}
