package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.PlanProduccion;
import com.pisip.jbpharma.dominio.repositorio.IPlanProduccionRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.PlanProduccionEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IPlanProduccionJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IPlanProduccionJpaRepositorio;

public class PlanProduccionRepositorioImpl implements IPlanProduccionRepositorio {
	
	private final IPlanProduccionJpaRepositorio jpaRepositorio;
	private final IPlanProduccionJpaMapper entityMapper;	
	
	public PlanProduccionRepositorioImpl(IPlanProduccionJpaRepositorio jpaRepositorio,
			IPlanProduccionJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public PlanProduccion guardar(PlanProduccion nuevoPlanProduccion) {
		PlanProduccionEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevoPlanProduccion));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<PlanProduccion> buscarPorId(int idPlan) {
		return jpaRepositorio.findById(idPlan).map(entityMapper::toDomain);
	}

	@Override
	public Optional<PlanProduccion> buscarPorCodigo(String codigoPlan) {
		return jpaRepositorio.findByCodigoPlan(codigoPlan).map(entityMapper::toDomain);
	}

	@Override
	public List<PlanProduccion> buscarPorEstado(String estado) {
		return jpaRepositorio.findByEstado(estado).stream().map(entityMapper::toDomain).toList();             
	}

	@Override
	public List<PlanProduccion> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idPlanProduccion) {
		jpaRepositorio.deleteById(idPlanProduccion);
	}

}
