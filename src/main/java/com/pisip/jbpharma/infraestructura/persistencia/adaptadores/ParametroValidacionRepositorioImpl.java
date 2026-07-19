package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.ParametroValidacion;
import com.pisip.jbpharma.dominio.repositorio.iParametroValidacionRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ParametroValidacionEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iParametroValidacionjpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.iParametroValidacionjpaRepositorio;

public class ParametroValidacionRepositorioImpl implements iParametroValidacionRepositorio{
	
	private final iParametroValidacionjpaRepositorio jpaRepositorio;
	private final iParametroValidacionjpaMapper entityMapper;
	


	public ParametroValidacionRepositorioImpl(iParametroValidacionjpaRepositorio jpaRepositorio,
			iParametroValidacionjpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ParametroValidacion guardar(ParametroValidacion nuevoParametroValidacion) {
		ParametroValidacionEntity entidad = entityMapper.toEntity(nuevoParametroValidacion);
		ParametroValidacionEntity guardado = jpaRepositorio.save(entidad);
		return entityMapper.toDominio(guardado);
	}

	@Override
	public Optional<ParametroValidacion> buscarPorId(int idParametroValidacion) {
		return jpaRepositorio.findById(idParametroValidacion).map(entityMapper :: toDominio);
	}

	@Override
	public List<ParametroValidacion> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDominio).toList();
	}

	@Override
	public void eliminar(int idParametroValidacion) {
		jpaRepositorio.deleteById(idParametroValidacion);
		
	}

}
