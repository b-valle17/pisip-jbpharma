package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.iAlertaEnsayoUseCase;
import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;
import com.pisip.jbpharma.dominio.repositorio.iAlertaEnsayoRepositorio;

public class AlertaEnsayoUseCaseImpl implements iAlertaEnsayoUseCase {
	
private final iAlertaEnsayoRepositorio repositorio;

	public AlertaEnsayoUseCaseImpl(iAlertaEnsayoRepositorio repositorio) {
	super();
	this.repositorio = repositorio;
}

	@Override
	public AlertaEnsayo guardar(AlertaEnsayo nuevaAlertaEnsayo) {
		// Justo aqui se aplican las reglas de negocio
		return repositorio.guardar(nuevaAlertaEnsayo);
	}

	@Override
	public AlertaEnsayo buscarPorId(int idAlertaEnsayo) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idAlertaEnsayo).orElseThrow(()->new RuntimeException("Alerta no encontrada"));
	}

	@Override
	public List<AlertaEnsayo> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idAlertaEnsayo) {
		repositorio.eliminar(idAlertaEnsayo);
		
	}

}



