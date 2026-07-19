package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.ParametroCalidad;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ParametroCalidadEntity;

@Mapper(componentModel = "spring")
public interface IParametroCalidadJpaMapper {

	ParametroCalidadEntity toEntity(ParametroCalidad parametroCalidad);

	ParametroCalidad toDomain(ParametroCalidadEntity parametroCalidadEntity);
}