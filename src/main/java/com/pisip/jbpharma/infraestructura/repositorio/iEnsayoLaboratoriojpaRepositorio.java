package com.pisip.jbpharma.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoLaboratorioEntity;

<<<<<<< Updated upstream
public interface iEnsayoLaboratoriojpaRepositorio extends JpaRepository<EnsayoLaboratorioEntity, Integer>{
=======
public interface iEnsayoLaboratoriojpaRepositorio extends JpaRepository<EnsayoLaboratorioEntity, Long> {
>>>>>>> Stashed changes

	List<EnsayoLaboratorioEntity> findByOrdenProduccion_IdOrdenOrderByFechaEnsayoDesc(Integer idOrden);
}
