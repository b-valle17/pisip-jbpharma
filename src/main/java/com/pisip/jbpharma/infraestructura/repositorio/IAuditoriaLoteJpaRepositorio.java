package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.AuditoriaLoteEntity;

public interface IAuditoriaLoteJpaRepositorio extends JpaRepository<AuditoriaLoteEntity, Integer> {
}
