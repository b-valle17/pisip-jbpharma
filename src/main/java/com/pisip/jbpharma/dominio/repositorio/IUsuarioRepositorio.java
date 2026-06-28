package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.Usuario;

public interface IUsuarioRepositorio {

	Usuario guardar(Usuario nuevoUsuario);

	Optional<Usuario> buscarPorId(int idUsuario);

	Optional<Usuario> buscarPorCorreo(String correo);

	Optional<Usuario> autenticar(String correo, String contrasenaHash);

	List<Usuario> listarTodos();

	void eliminar(int idUsuario);
}