package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;
import com.pisip.jbpharma.dominio.repositorio.IAuditoriaLoteRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.AuditoriaLoteEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IAuditoriaLoteJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IAuditoriaLoteJpaRepositorio;

public class AuditoriaLoteRepositorioImpl implements IAuditoriaLoteRepositorio {

	private final IAuditoriaLoteJpaRepositorio jpaRepositorio;
	private final IAuditoriaLoteJpaMapper entityMapper;

	public AuditoriaLoteRepositorioImpl(IAuditoriaLoteJpaRepositorio jpaRepositorio, IAuditoriaLoteJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@SuppressWarnings("null")
	@Override
	public AuditoriaLote guardar(AuditoriaLote nuevaAuditoriaLote) {
		AuditoriaLoteEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevaAuditoriaLote));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<AuditoriaLote> buscarPorId(int idAuditoria) {
		return jpaRepositorio.findById(idAuditoria).map(entityMapper::toDomain);
	}

	@Override
	public List<AuditoriaLote> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idAuditoria) {
		jpaRepositorio.deleteById(idAuditoria);
	}
}
