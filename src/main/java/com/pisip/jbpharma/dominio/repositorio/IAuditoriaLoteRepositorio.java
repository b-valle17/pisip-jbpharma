package com.pisip.jbpharma.dominio.repositorio;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;

public interface IAuditoriaLoteRepositorio {

	AuditoriaLote guardar(AuditoriaLote nuevaAuditoria);

	Optional<AuditoriaLote> buscarPorId(int idAuditoria);

	List<AuditoriaLote> listarTodos();

	void eliminar(int idAuditoria);
}
