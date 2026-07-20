package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.DictamenLoteEntity;

public interface IDictamenLoteJpaRepositorio extends JpaRepository<DictamenLoteEntity, Integer> {
}
