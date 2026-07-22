package com.pisip.jbpharma.infraestructura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.DictamenLoteEntity;

public interface IDictamenLoteJpaRepositorio extends JpaRepository<DictamenLoteEntity, Integer> {

	List<DictamenLoteEntity> findByOrdenProduccion_IdOrdenOrderByFechaDictamenDesc(Integer idOrden);
}
