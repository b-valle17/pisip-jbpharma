package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.PlanProduccion;

public interface IPlanProduccionUseCase {
	
	PlanProduccion guardar(PlanProduccion nuevoPlanProduccion);
	
	PlanProduccion buscarPorId(int idPlan);
	
	PlanProduccion buscarPorCodigo(String codigoPlan);
	
	List<PlanProduccion> buscarPorEstado(String estado);
	
	List<PlanProduccion> listarTodos();
	
	void eliminar(int idPlanProduccion);

}
