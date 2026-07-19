package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.Rol;
import com.pisip.jbpharma.dominio.repositorio.IRolRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.RolEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IRolJpaRepositorio;

public class RolRepositorioImpl implements IRolRepositorio {

	private final IRolJpaRepositorio jpaRepositorio;
	private final IRolJpaMapper entityMapper;

	public RolRepositorioImpl(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@SuppressWarnings("null")
	@Override
	public Rol guardar(Rol nuevoRol) {
		RolEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevoRol));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Rol> buscarPorId(int idRol) {
		return jpaRepositorio.findById(idRol).map(entityMapper::toDomain);
	}

	@Override
	public List<Rol> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idRol) {
		jpaRepositorio.deleteById(idRol);
	}
}