package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.Usuario;

public interface iUsuarioUseCase {
	
	Usuario guardar(Usuario nuevoUsuario);
	Usuario buscarPorId(int idUsuario);
	List<Usuario> listarTodos();
	void eliminar(int idUsuario);

}
