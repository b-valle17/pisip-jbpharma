package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.RolEntity;

public interface IRolJpaRepositorio extends JpaRepository<RolEntity, Integer> {
}