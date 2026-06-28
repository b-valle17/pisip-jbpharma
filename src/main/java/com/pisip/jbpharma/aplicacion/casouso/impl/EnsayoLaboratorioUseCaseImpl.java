package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;


public class EnsayoLaboratorioUseCaseImpl implements iEnsayoLaboratorioUseCase{

	private final iEnsayoLaboratorioRepositorio repositorio;

	
	public EnsayoLaboratorioUseCaseImpl(iEnsayoLaboratorioRepositorio repositorio) {
		
		this.repositorio = repositorio;
	}

	@Override
	public EnsayoLaboratorio guardar(EnsayoLaboratorio nuevaCategoria) {
		// Justo aqui se aplican las reglas de negocio
		return repositorio.guardar(nuevaCategoria);
	}

	@Override
	public EnsayoLaboratorio buscarPorId(int idEnsayoLaboratorio) {
		// TODO Auto-generated method stub
		return repositorio.buscarPorId(idEnsayoLaboratorio).orElseThrow(()->new RuntimeException("Ensayo de laboratorio no encontrado"));
	}

	@Override
	public List<EnsayoLaboratorio> listarTodos() {
		// TODO Auto-generated method stub
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idEnsayoLaboratorio) {
		repositorio.eliminar(idEnsayoLaboratorio);
		
	}
}
