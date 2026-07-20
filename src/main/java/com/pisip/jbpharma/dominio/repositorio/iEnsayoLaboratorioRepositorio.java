package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;

public interface iEnsayoLaboratorioRepositorio {
	
	EnsayoLaboratorio guardar(EnsayoLaboratorio nuevoEnsayoLaboratorio);
	Optional<EnsayoLaboratorio> buscarPorId(long idEnsayoLaboratorio);
	List<EnsayoLaboratorio> listarTodos();
	void eliminar(long idEnsayoLaboratorio);

}
