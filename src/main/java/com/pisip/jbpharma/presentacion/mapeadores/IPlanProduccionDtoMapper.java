package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.PlanProduccion;
import com.pisip.jbpharma.presentacion.dto.request.PlanProduccionRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.PlanProduccionResponseDto;

@Mapper(componentModel = "spring")
public interface IPlanProduccionDtoMapper {
	
	PlanProduccion toDomain(PlanProduccionRequestDto dto);

	PlanProduccionResponseDto toResponseDto(PlanProduccion planProduccion);

}
