package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.Producto;

public interface IProductoRepositorio {

	Producto guardar(Producto nuevoProducto);

	Optional<Producto> buscarPorId(int idProducto);

	List<Producto> listarTodos();

	void eliminar(int idProducto);
}