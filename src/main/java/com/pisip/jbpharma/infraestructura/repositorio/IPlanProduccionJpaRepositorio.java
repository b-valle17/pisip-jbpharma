package com.pisip.jbpharma.infraestructura.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.PlanProduccionEntity;

public interface IPlanProduccionJpaRepositorio extends JpaRepository<PlanProduccionEntity, Integer>{

	Optional<PlanProduccionEntity> findByCodigoPlan(String codigoPlan);
	List<PlanProduccionEntity> findByEstado(String estado);

}
