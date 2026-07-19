package com.pisip.jbpharma.infraestructura.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pisip.jbpharma.infraestructura.persistencia.jpa.UsuarioEntity;

public interface IUsuarioJpaRepositorio extends JpaRepository<UsuarioEntity, Integer> {

	Optional<UsuarioEntity> findByCorreo(String correo);

	Optional<UsuarioEntity> findByCorreoAndContrasenaHash(String correo, String contrasenaHash);
}