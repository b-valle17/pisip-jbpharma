package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.Producto;
import com.pisip.jbpharma.dominio.repositorio.IProductoRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ProductoEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IProductoJpaRepositorio;

public class ProductoRepositorioImpl implements IProductoRepositorio {

	private final IProductoJpaRepositorio jpaRepositorio;
	private final IProductoJpaMapper entityMapper;

	public ProductoRepositorioImpl(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Producto guardar(Producto nuevoProducto) {
		ProductoEntity guardado = jpaRepositorio.save(entityMapper.toEntity(nuevoProducto));
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Producto> buscarPorId(int idProducto) {
		return jpaRepositorio.findById(idProducto).map(entityMapper::toDomain);
	}

	@Override
	public List<Producto> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idProducto) {
		jpaRepositorio.deleteById(idProducto);
	}
}