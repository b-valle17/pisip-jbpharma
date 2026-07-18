package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;

public interface IInformeAuditoriaUseCase {

	InformeAuditoria guardar(InformeAuditoria nuevoInformeAuditoria);

	InformeAuditoria buscarPorId(int idInforme);

	List<InformeAuditoria> listarTodos();

	InformeAuditoria actualizar(int id, InformeAuditoria informeAuditoria);

	void eliminar(int idInforme);
}
