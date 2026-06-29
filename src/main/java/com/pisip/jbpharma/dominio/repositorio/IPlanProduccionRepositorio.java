package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;
import com.pisip.jbpharma.dominio.entidades.PlanProduccion;

public interface IPlanProduccionRepositorio {

	PlanProduccion guardar(PlanProduccion nuevoPlanProduccion);
	
	Optional<PlanProduccion>buscarPorId(int idPlan);
	
	Optional<PlanProduccion>buscarPorCodigo(String codigoPlan);
	
	List<PlanProduccion> buscarPorEstado(String estado);
	
	List<PlanProduccion> listarTodos();
	
	void eliminar(int idPlanProduccion);
}
