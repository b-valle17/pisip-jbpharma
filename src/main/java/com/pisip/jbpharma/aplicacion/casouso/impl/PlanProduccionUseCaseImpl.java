package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IPlanProduccionUseCase;
import com.pisip.jbpharma.dominio.entidades.PlanProduccion;
import com.pisip.jbpharma.dominio.repositorio.IPlanProduccionRepositorio;

public class PlanProduccionUseCaseImpl implements IPlanProduccionUseCase{
	
	private final IPlanProduccionRepositorio repositorio;
	
	public PlanProduccionUseCaseImpl(IPlanProduccionRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public PlanProduccion guardar(PlanProduccion nuevoPlanProduccion) {
		return repositorio.guardar(nuevoPlanProduccion);
	}

	@Override
	public PlanProduccion buscarPorId(int idPlan) {
		return repositorio.buscarPorId(idPlan).orElseThrow(() -> new RuntimeException("Plan no encontrado"));
	}

	@Override
	public PlanProduccion buscarPorCodigo(String codigoPlan) {
		return repositorio.buscarPorCodigo(codigoPlan).orElseThrow(() -> new RuntimeException("Codigo no encontrado"));
	}

	@Override
	public List<PlanProduccion> buscarPorEstado(String estado) {
		return repositorio.buscarPorEstado(estado);
	}

	@Override
	public List<PlanProduccion> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idPlanProduccion) {
		repositorio.eliminar(idPlanProduccion);
		
	}

}
