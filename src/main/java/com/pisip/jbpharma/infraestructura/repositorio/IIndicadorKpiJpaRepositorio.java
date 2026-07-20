package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.IndicadorKpiEntity;

public interface IIndicadorKpiJpaRepositorio extends JpaRepository<IndicadorKpiEntity, Integer> {
}
