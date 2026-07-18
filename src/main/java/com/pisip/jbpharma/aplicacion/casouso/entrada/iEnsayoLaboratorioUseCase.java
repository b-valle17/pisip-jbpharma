package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;


public interface iEnsayoLaboratorioUseCase {
	
	EnsayoLaboratorio guardar(EnsayoLaboratorio nuevoEnsayoLaboratorio);
	EnsayoLaboratorio buscarPorId(int idEnsayoLaboratorio);
	List<EnsayoLaboratorio> listarTodos();
	void eliminar(int idEnsayoLaboratorio);

}
