package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;
import com.pisip.jbpharma.dominio.repositorio.IInformeAuditoriaRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.InformeAuditoriaEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IInformeAuditoriaJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IInformeAuditoriaJpaRepositorio;

public class InformeAuditoriaRepositorioImpl implements IInformeAuditoriaRepositorio {

	private final IInformeAuditoriaJpaRepositorio jpaRepositorio;
	private final IInformeAuditoriaJpaMapper entityMapper;

	public InformeAuditoriaRepositorioImpl(IInformeAuditoriaJpaRepositorio jpaRepositorio, IInformeAuditoriaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@SuppressWarnings("null")
	@Override
	public InformeAuditoria guardar(InformeAuditoria nuevoInformeAuditoria) {
		InformeAuditoriaEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevoInformeAuditoria));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<InformeAuditoria> buscarPorId(int idInforme) {
		return jpaRepositorio.findById(idInforme).map(entityMapper::toDomain);
	}

	@Override
	public List<InformeAuditoria> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idInforme) {
		jpaRepositorio.deleteById(idInforme);
	}
}
