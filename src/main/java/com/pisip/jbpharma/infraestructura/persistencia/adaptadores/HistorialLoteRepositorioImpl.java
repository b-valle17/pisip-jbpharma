package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.HistorialLote;
import com.pisip.jbpharma.dominio.repositorio.IHistorialLoteRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.HistorialLoteEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IHistorialLoteJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IHistorialLoteJpaRepositorio;

public class HistorialLoteRepositorioImpl implements IHistorialLoteRepositorio {

	private final IHistorialLoteJpaRepositorio jpaRepositorio;
	private final IHistorialLoteJpaMapper entityMapper;

	public HistorialLoteRepositorioImpl(IHistorialLoteJpaRepositorio jpaRepositorio, IHistorialLoteJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@SuppressWarnings("null")
	@Override
	public HistorialLote guardar(HistorialLote nuevoHistorialLote) {
		HistorialLoteEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevoHistorialLote));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<HistorialLote> buscarPorId(int idHistorial) {
		return jpaRepositorio.findById(idHistorial).map(entityMapper::toDomain);
	}

	@Override
	public List<HistorialLote> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idHistorial) {
		jpaRepositorio.deleteById(idHistorial);
	}
}
