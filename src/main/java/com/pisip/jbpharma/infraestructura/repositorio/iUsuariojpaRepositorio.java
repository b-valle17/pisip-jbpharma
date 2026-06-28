package com.pisip.jbpharma.infraestructura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.UsuarioEntity;

public interface iUsuariojpaRepositorio extends JpaRepository<UsuarioEntity, Integer> {

}
