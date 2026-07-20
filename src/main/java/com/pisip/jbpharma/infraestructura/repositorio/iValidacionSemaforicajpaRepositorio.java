package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.ValidacionSemaforicaEntity;

public interface iValidacionSemaforicajpaRepositorio extends JpaRepository<ValidacionSemaforicaEntity, Long> {

}
