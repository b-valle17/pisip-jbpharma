package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;

public interface IInformeAuditoriaUseCase {

	InformeAuditoria guardar(InformeAuditoria nuevoInforme);

	InformeAuditoria buscarPorId(int idInforme);

	List<InformeAuditoria> listarTodos();

	void eliminar(int idInforme);
}
