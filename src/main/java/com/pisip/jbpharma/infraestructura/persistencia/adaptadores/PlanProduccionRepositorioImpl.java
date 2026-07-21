package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.PlanProduccion;
import com.pisip.jbpharma.dominio.repositorio.IPlanProduccionRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.PlanProduccionEntity;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.UsuarioEntity; // <-- Agregar import
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IPlanProduccionJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IPlanProduccionJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IUsuarioJpaRepositorio; // <-- Agregar import

public class PlanProduccionRepositorioImpl implements IPlanProduccionRepositorio {
	
	private final IPlanProduccionJpaRepositorio jpaRepositorio;
	private final IUsuarioJpaRepositorio usuarioJpaRepositorio; 
	private final IPlanProduccionJpaMapper entityMapper;	

	public PlanProduccionRepositorioImpl(IPlanProduccionJpaRepositorio jpaRepositorio,
			IUsuarioJpaRepositorio usuarioJpaRepositorio,
			IPlanProduccionJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.usuarioJpaRepositorio = usuarioJpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public PlanProduccion guardar(PlanProduccion nuevoPlanProduccion) {
		PlanProduccionEntity entidad = entityMapper.toEntity(nuevoPlanProduccion);

		if (nuevoPlanProduccion.getIdUsuario() != null) {
			UsuarioEntity usuarioEntity = usuarioJpaRepositorio.findById(nuevoPlanProduccion.getIdUsuario())
					.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + nuevoPlanProduccion.getIdUsuario()));
			entidad.setUsuario(usuarioEntity);
		} else {
			throw new IllegalArgumentException("El idUsuario es obligatorio para guardar un Plan de Producción");
		}

		PlanProduccionEntity guardado = jpaRepositorio.save(entidad);
		
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