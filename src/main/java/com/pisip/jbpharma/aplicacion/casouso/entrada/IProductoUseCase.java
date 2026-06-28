package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.Producto;

public interface IProductoUseCase {

	Producto guardar(Producto nuevoProducto);

	Producto buscarPorId(int idProducto);

	List<Producto> listarTodos();
	
	Producto actualizar(int id, Producto producto);

	void eliminar(int idProducto);
}