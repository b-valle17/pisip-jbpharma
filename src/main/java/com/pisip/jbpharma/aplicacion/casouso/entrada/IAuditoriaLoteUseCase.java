package com.pisip.jbpharma.aplicacion.casouso.entrada;

import java.util.List;

import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;

public interface IAuditoriaLoteUseCase {

	AuditoriaLote guardar(AuditoriaLote nuevaAuditoriaLote);

	AuditoriaLote buscarPorId(int idAuditoria);

	List<AuditoriaLote> listarTodos();

	AuditoriaLote actualizar(int id, AuditoriaLote auditoriaLote);

	void eliminar(int idAuditoria);
}
