package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;
import com.pisip.jbpharma.dominio.repositorio.iValidacionSemaforicaRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ValidacionSemaforicaEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iValidacionSemaforicajpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.iValidacionSemaforicajpaRepositorio;

public class ValidacionSemaforicaRepositorioImpl implements iValidacionSemaforicaRepositorio {
	

	private final iValidacionSemaforicajpaRepositorio jpaRepositorio;
	private final iValidacionSemaforicajpaMapper entityMapper;
	
	public ValidacionSemaforicaRepositorioImpl(iValidacionSemaforicajpaRepositorio jpaRepositorio,
			iValidacionSemaforicajpaMapper entityMapper) {
		
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public ValidacionSemaforica guardar(ValidacionSemaforica nuevaValidacionSemaforica) {
		ValidacionSemaforicaEntity entidad = entityMapper.toEntity(nuevaValidacionSemaforica);
		ValidacionSemaforicaEntity guardado = jpaRepositorio.save(entidad);
		return entityMapper.toDominio(guardado);
	}

	@Override
	public Optional<ValidacionSemaforica> buscarPorId(long idValidacionSemaforica) {
		return jpaRepositorio.findById(idValidacionSemaforica).map(entityMapper :: toDominio);
	}

	@Override
	public List<ValidacionSemaforica> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDominio).toList();
	}

	@Override
	public void eliminar(long idValidacionSemaforica) {
		jpaRepositorio.deleteById(idValidacionSemaforica);
		
	}
	

}
