package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;


public interface iAlertaEnsayoUseCase {

	AlertaEnsayo guardar(AlertaEnsayo nuevaAlertaEnsayo);
	AlertaEnsayo buscarPorId(int idAlertaEnsayo);
	List<AlertaEnsayo> listarTodos();
	void eliminar(int idAlertaEnsayo);
}
