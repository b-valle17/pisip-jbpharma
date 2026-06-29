package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.presentacion.dto.request.DictamenLoteRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.DictamenLoteResponseDto;

@Mapper(componentModel = "spring")
public interface IDictamenLoteDtoMapper {

	DictamenLote toDomain(DictamenLoteRequestDto dto);

	DictamenLoteResponseDto toResponseDto(DictamenLote dictamenLote);
}
