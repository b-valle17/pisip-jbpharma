package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.Rol;

public interface IRolUseCase {

	Rol guardar(Rol nuevoRol);

	Rol buscarPorId(int idRol);

	List<Rol> listarTodos();

	void eliminar(int idRol);
}