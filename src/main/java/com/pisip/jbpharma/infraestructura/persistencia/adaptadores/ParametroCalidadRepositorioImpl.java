package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.ParametroCalidad;
import com.pisip.jbpharma.dominio.repositorio.IParametroCalidadRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ParametroCalidadEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IParametroCalidadJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IParametroCalidadJpaRepositorio;

public class ParametroCalidadRepositorioImpl implements IParametroCalidadRepositorio {

	private final IParametroCalidadJpaRepositorio jpaRepositorio;
	private final IParametroCalidadJpaMapper entityMapper;

	public ParametroCalidadRepositorioImpl(IParametroCalidadJpaRepositorio jpaRepositorio,
			IParametroCalidadJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@SuppressWarnings("null")
	@Override
	public ParametroCalidad guardar(ParametroCalidad nuevoParametro) {
		ParametroCalidadEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevoParametro));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<ParametroCalidad> buscarPorId(int idParametro) {
		return jpaRepositorio.findById(idParametro).map(entityMapper::toDomain);
	}

	@Override
	public List<ParametroCalidad> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idParametro) {
		jpaRepositorio.deleteById(idParametro);
	}
}