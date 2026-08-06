package com.pisip.jbpharma.infraestructura.repositorio;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoLaboratorioEntity;

public interface iEnsayoLaboratoriojpaRepositorio extends JpaRepository<EnsayoLaboratorioEntity, Long> {

	List<EnsayoLaboratorioEntity> findByOrdenProduccion_IdOrdenOrderByFechaEnsayoDesc(Integer idOrden);
	 boolean existsByOrdenProduccion_IdOrdenAndEstadoNotIn(
	            Integer idOrden,
	            Collection<String> estadosTerminales
	    );
}
