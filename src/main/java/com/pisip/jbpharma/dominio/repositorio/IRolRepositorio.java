package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.Rol;

public interface IRolRepositorio {

	Rol guardar(Rol nuevoRol);

	Optional<Rol> buscarPorId(int idRol);

	List<Rol> listarTodos();

	void eliminar(int idRol);
}