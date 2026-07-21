package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;

public interface iEnsayoVariableRepositorio {
	
	EnsayoVariable guardar(EnsayoVariable nuevoEnsayoVariable);
	Optional<EnsayoVariable> buscarPorId(long idEnsayoVariable);
	List<EnsayoVariable> listarTodos();
	void eliminar(long idEnsayoVariable);

}
