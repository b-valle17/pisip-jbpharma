package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;

public interface iAlertaEnsayoRepositorio {
	
	AlertaEnsayo guardar(AlertaEnsayo nuevaAlertaEnsayo);
	Optional<AlertaEnsayo> buscarPorId(long idAlertaEnsayo);
	List<AlertaEnsayo> listarTodos();
	void eliminar(long idAlertaEnsayo);

}
