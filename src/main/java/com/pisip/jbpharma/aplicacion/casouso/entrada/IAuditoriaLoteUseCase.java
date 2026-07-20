package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;

public interface IAuditoriaLoteUseCase {

	AuditoriaLote guardar(AuditoriaLote nuevaAuditoria);

	AuditoriaLote buscarPorId(int idAuditoria);

	List<AuditoriaLote> listarTodos();

	void eliminar(int idAuditoria);
}
