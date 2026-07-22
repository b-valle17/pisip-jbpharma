package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.dominio.repositorio.IDictamenLoteRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.DictamenLoteEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IDictamenLoteJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IDictamenLoteJpaRepositorio;

public class DictamenLoteRepositorioImpl implements IDictamenLoteRepositorio {

	private final IDictamenLoteJpaRepositorio jpaRepositorio;
	private final IDictamenLoteJpaMapper entityMapper;

	public DictamenLoteRepositorioImpl(IDictamenLoteJpaRepositorio jpaRepositorio,
			IDictamenLoteJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@SuppressWarnings("null")
	@Override
	public DictamenLote guardar(DictamenLote nuevoDictamen) {
		DictamenLoteEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevoDictamen));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<DictamenLote> buscarPorId(int idDictamen) {
		return jpaRepositorio.findById(idDictamen).map(entityMapper::toDomain);
	}

	@Override
	public List<DictamenLote> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDictamen) {
		jpaRepositorio.deleteById(idDictamen);
	}

	@Override
	public Optional<DictamenLote> buscarPorIdOrdenProduccion(int idOrdenProduccion) {
		return jpaRepositorio.findByOrdenProduccion_IdOrdenOrderByFechaDictamenDesc(idOrdenProduccion)
				.stream()
				.findFirst()
				.map(entityMapper::toDomain);
	}
}
