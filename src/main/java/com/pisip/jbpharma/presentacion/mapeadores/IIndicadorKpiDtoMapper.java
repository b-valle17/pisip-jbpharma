package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;
import com.pisip.jbpharma.presentacion.dto.request.IndicadorKpiRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.IndicadorKpiResponseDto;

@Mapper(componentModel = "spring")
public interface IIndicadorKpiDtoMapper {

	IndicadorKpi toDomain(IndicadorKpiRequestDto dto);

	IndicadorKpiResponseDto toResponseDto(IndicadorKpi indicadorKpi);
}
