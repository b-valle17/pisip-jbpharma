package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.PlanProduccion;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.PlanProduccionEntity;

@Mapper(componentModel = "spring")
public interface IPlanProduccionJpaMapper {
	
	PlanProduccionEntity toEntity(PlanProduccion planProduccion);

	PlanProduccion toDomain(PlanProduccionEntity planProduccionEntity);
}
