package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.HistorialLote;

public interface IHistorialLoteRepositorio {

	HistorialLote guardar(HistorialLote nuevoHistorial);

	Optional<HistorialLote> buscarPorId(int idHistorial);

	List<HistorialLote> listarTodos();

	void eliminar(int idHistorial);
}
