package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;
import com.pisip.jbpharma.dominio.repositorio.iValidacionSemaforicaRepositorio;

public class ValidacionSemaforicaUseCaseImpl implements iValidacionSemaforicaUseCase{
	
private final iValidacionSemaforicaRepositorio repositorio;
	
	public ValidacionSemaforicaUseCaseImpl(iValidacionSemaforicaRepositorio repositorio) {
	
	this.repositorio = repositorio;
}

	@Override
	public ValidacionSemaforica guardar(ValidacionSemaforica nuevaValidacionSemaforica) {
		// Justo aqui se aplican las reglas de negocio
		return repositorio.guardar(nuevaValidacionSemaforica);
	}

	@Override
	public ValidacionSemaforica buscarPorId(int idValidacionSemaforica) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idValidacionSemaforica).orElseThrow(()->new RuntimeException("Validacion semaforica no encontrada"));
	}

	@Override
	public List<ValidacionSemaforica> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idValidacionSemaforica) {
		repositorio.eliminar(idValidacionSemaforica);
		
	}

}
