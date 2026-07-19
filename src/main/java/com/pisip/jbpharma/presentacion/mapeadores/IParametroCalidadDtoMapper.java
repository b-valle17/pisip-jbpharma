package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.ParametroCalidad;
import com.pisip.jbpharma.presentacion.dto.request.ParametroCalidadRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.ParametroCalidadResponseDto;

@Mapper(componentModel = "spring")
public interface IParametroCalidadDtoMapper {

	ParametroCalidad toDomain(ParametroCalidadRequestDto dto);

	ParametroCalidadResponseDto toResponseDto(ParametroCalidad parametroCalidad);
}