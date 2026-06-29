package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;
import com.pisip.jbpharma.dominio.repositorio.IOrdenProduccionRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.OrdenProduccionEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IOrdenProduccionJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IOrdenProduccionJpaRepositorio;

public class OrdenProduccionRepositorioImpl implements IOrdenProduccionRepositorio{

	private final IOrdenProduccionJpaRepositorio jpaRepositorio;
	private final IOrdenProduccionJpaMapper entityMapper;
	
	public OrdenProduccionRepositorioImpl(IOrdenProduccionJpaRepositorio jpaRepositorio,
			IOrdenProduccionJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public OrdenProduccion guardar(OrdenProduccion nuevaOrdenProduccion) {
		OrdenProduccionEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevaOrdenProduccion));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<OrdenProduccion> buscarPorId(int idOrden) {
		return jpaRepositorio.findById(idOrden).map(entityMapper::toDomain);
	}

	@Override
	public Optional<OrdenProduccion> buscarPorNumeroLote(String numeroLote) {
		return jpaRepositorio.findByNumeroLote(numeroLote).map(entityMapper::toDomain);
	}

	@Override
	public List<OrdenProduccion> buscarPorEstado(String estado) {
		return jpaRepositorio.findByEstado(estado)
                .stream()
                .map(entityMapper::toDomain)
                .toList();
	}

	@Override
	public List<OrdenProduccion> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idOrdenProduccion) {
		jpaRepositorio.deleteById(idOrdenProduccion);
	}

}
