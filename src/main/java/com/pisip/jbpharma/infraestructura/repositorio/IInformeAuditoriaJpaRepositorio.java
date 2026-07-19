package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.InformeAuditoriaEntity;

public interface IInformeAuditoriaJpaRepositorio extends JpaRepository<InformeAuditoriaEntity, Integer> {
}
