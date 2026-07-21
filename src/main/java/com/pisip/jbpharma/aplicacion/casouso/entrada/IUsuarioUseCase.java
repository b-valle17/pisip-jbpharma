package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.Usuario;

public interface IUsuarioUseCase {

	Usuario guardar(Usuario nuevoUsuario);

	Usuario buscarPorId(int idUsuario);

	Usuario autenticar(String correo, String contrasenaHash);

	List<Usuario> listarTodos();

	void eliminar(int idUsuario);
	
	Usuario actualizar(int id, Usuario usuario);
	
	boolean existePorCorreo(String correo);
}