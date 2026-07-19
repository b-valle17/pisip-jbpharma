package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.HistorialLoteEntity;

public interface IHistorialLoteJpaRepositorio extends JpaRepository<HistorialLoteEntity, Integer> {
}
