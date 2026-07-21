package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;

public interface iEnsayoLaboratorioRepositorio {

	EnsayoLaboratorio guardar(EnsayoLaboratorio nuevoEnsayoLaboratorio);
	Optional<EnsayoLaboratorio> buscarPorId(int idEnsayoLaboratorio);
	List<EnsayoLaboratorio> listarTodos();
	void eliminar(int idEnsayoLaboratorio);

	/** Busca el ultimo ensayo de laboratorio registrado para una orden de produccion (lote) especifica. */
	Optional<EnsayoLaboratorio> buscarPorIdOrden(int idOrden);
}
