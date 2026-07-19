package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;
import com.pisip.jbpharma.dominio.repositorio.IIndicadorKpiRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.IndicadorKpiEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IIndicadorKpiJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IIndicadorKpiJpaRepositorio;

public class IndicadorKpiRepositorioImpl implements IIndicadorKpiRepositorio {

	private final IIndicadorKpiJpaRepositorio jpaRepositorio;
	private final IIndicadorKpiJpaMapper entityMapper;

	public IndicadorKpiRepositorioImpl(IIndicadorKpiJpaRepositorio jpaRepositorio,
			IIndicadorKpiJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@SuppressWarnings("null")
	@Override
	public IndicadorKpi guardar(IndicadorKpi nuevoIndicador) {
		IndicadorKpiEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevoIndicador));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<IndicadorKpi> buscarPorId(int idKpi) {
		return jpaRepositorio.findById(idKpi).map(entityMapper::toDomain);
	}

	@Override
	public List<IndicadorKpi> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idKpi) {
		jpaRepositorio.deleteById(idKpi);
	}
}
