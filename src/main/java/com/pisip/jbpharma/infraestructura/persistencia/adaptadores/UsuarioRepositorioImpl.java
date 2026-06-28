package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.dominio.repositorio.iUsuarioRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.UsuarioEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iUsuariojpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.iUsuariojpaRepositorio;

public class UsuarioRepositorioImpl implements iUsuarioRepositorio{

	
	private final iUsuariojpaRepositorio jpaRepositorio;
	private final iUsuariojpaMapper entityMapper;

	public UsuarioRepositorioImpl(iUsuariojpaRepositorio jpaRepositorio, iUsuariojpaMapper entityMapper) {
		
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Usuario guardar(Usuario nuevoUsuario) {
		UsuarioEntity entidad = entityMapper.toEntity(nuevoUsuario);
		UsuarioEntity guardado = jpaRepositorio.save(entidad);
		return entityMapper.toDominio(guardado);
	}

	@Override
	public Optional<Usuario> buscarPorId(int idUsuario) {
		return jpaRepositorio.findById(idUsuario).map(entityMapper :: toDominio);
	}

	@Override
	public List<Usuario> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDominio).toList();
	}

	@Override
	public void eliminar(int idUsuario) {
		jpaRepositorio.deleteById(idUsuario);
		
	}
	
}
