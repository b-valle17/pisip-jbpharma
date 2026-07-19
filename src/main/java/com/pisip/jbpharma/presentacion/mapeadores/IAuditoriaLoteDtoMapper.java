package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;
import com.pisip.jbpharma.presentacion.dto.request.AuditoriaLoteRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.AuditoriaLoteResponseDto;

@Mapper(componentModel = "spring")
public interface IAuditoriaLoteDtoMapper {

	AuditoriaLote toDomain(AuditoriaLoteRequestDto dto);

	AuditoriaLoteResponseDto toResponseDto(AuditoriaLote auditoriaLote);
}
