package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.HistorialLote;
import com.pisip.jbpharma.presentacion.dto.request.HistorialLoteRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.HistorialLoteResponseDto;

@Mapper(componentModel = "spring")
public interface IHistorialLoteDtoMapper {

	HistorialLote toDomain(HistorialLoteRequestDto dto);

	HistorialLoteResponseDto toResponseDto(HistorialLote historialLote);
}
