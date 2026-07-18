package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoVariableRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoVariableEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoVariablejpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoVariablejpaRepositorio;



public class EnsayoVariableRepositorioImpl implements iEnsayoVariableRepositorio {

	private final iEnsayoVariablejpaRepositorio jpaRepositorio;
	private final iEnsayoVariablejpaMapper entityMapper;
	
	public EnsayoVariableRepositorioImpl(iEnsayoVariablejpaRepositorio jpaRepositorio,
			iEnsayoVariablejpaMapper entityMapper) {
		
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public EnsayoVariable guardar(EnsayoVariable nuevoEnsayoVariable) {
		EnsayoVariableEntity entidad = entityMapper.toEntity(nuevoEnsayoVariable);
		EnsayoVariableEntity guardado = jpaRepositorio.save(entidad);
		return entityMapper.toDominio(guardado);
	}

	@Override
	public Optional<EnsayoVariable> buscarPorId(int idEnsayoVariable) {
		return jpaRepositorio.findById(idEnsayoVariable).map(entityMapper :: toDominio);
	}

	@Override
	public List<EnsayoVariable> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDominio).toList();
	}

	@Override
	public void eliminar(int idEnsayoVariable) {
		jpaRepositorio.deleteById(idEnsayoVariable);
		
	}
	
}
