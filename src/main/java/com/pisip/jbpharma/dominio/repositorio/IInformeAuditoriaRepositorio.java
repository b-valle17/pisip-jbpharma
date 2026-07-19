package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;

public interface IInformeAuditoriaRepositorio {

	InformeAuditoria guardar(InformeAuditoria nuevoInforme);

	Optional<InformeAuditoria> buscarPorId(int idInforme);

	List<InformeAuditoria> listarTodos();

	void eliminar(int idInforme);
}
