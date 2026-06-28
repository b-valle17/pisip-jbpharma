package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;

public interface iEnsayoVariableUseCase {
	
	EnsayoVariable guardar(EnsayoVariable nuevoEnsayoVariable);
	EnsayoVariable buscarPorId(int idEnsayoVariable);
	List<EnsayoVariable> listarTodos();
	void eliminar(int idEnsayoVariable);

}
