package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.jbpharma.dominio.entidades.PlanProduccion;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.PlanProduccionEntity;

@Mapper(componentModel = "spring")
public interface IPlanProduccionJpaMapper {

    @Mapping(source = "idUsuario", target = "usuario.idUsuario")
    PlanProduccionEntity toEntity(PlanProduccion planProduccion);

    @Mapping(source = "usuario.idUsuario", target = "idUsuario")
    PlanProduccion toDomain(PlanProduccionEntity planProduccionEntity);
}