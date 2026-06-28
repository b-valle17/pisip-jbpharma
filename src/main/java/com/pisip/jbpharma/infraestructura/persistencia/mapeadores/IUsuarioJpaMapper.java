package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.UsuarioEntity;

@Mapper(componentModel = "spring")
public interface IUsuarioJpaMapper {

	UsuarioEntity toEntity(Usuario usuario);

	Usuario toDomain(UsuarioEntity usuarioEntity);
}