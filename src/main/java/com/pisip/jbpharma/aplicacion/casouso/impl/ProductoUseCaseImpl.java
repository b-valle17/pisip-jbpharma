package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IProductoUseCase;
import com.pisip.jbpharma.dominio.entidades.Producto;
import com.pisip.jbpharma.dominio.repositorio.IProductoRepositorio;

public class ProductoUseCaseImpl implements IProductoUseCase {

	private final IProductoRepositorio repositorio;

	public ProductoUseCaseImpl(IProductoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Producto guardar(Producto nuevoProducto) {
		return repositorio.guardar(nuevoProducto);
	}

	@Override
	public Producto buscarPorId(int idProducto) {
		return repositorio.buscarPorId(idProducto).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
	}

	@Override
	public List<Producto> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idProducto) {
		repositorio.eliminar(idProducto);
	}

	@Override
	public Producto actualizar(int id, Producto productoDatos) {
		buscarPorId(id);
		productoDatos.setIdProducto(id);
		return repositorio.guardar(productoDatos);
	}
}