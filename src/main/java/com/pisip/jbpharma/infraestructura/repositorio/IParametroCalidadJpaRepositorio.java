package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.ParametroCalidadEntity;

public interface IParametroCalidadJpaRepositorio extends JpaRepository<ParametroCalidadEntity, Integer> {
}