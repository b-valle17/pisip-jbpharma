package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.Rol;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.RolEntity;

@Mapper(componentModel = "spring")
public interface IRolJpaMapper {

	RolEntity toEntity(Rol rol);

	Rol toDomain(RolEntity rolEntity);
}