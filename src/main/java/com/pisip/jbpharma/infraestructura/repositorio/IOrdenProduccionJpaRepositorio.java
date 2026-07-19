package com.pisip.jbpharma.infraestructura.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.OrdenProduccionEntity;

public interface IOrdenProduccionJpaRepositorio extends JpaRepository<OrdenProduccionEntity, Integer> {
	
	Optional<OrdenProduccionEntity> findByNumeroLote(String numeroLote);
	List<OrdenProduccionEntity> findByEstado(String estado);

}
