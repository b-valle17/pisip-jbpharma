package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;
import com.pisip.jbpharma.presentacion.dto.request.OrdenProduccionRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.OrdenProduccionResponseDto;

@Mapper(componentModel = "spring")
public interface IOrdenProduccionDtoMapper {

    OrdenProduccion toDomain(OrdenProduccionRequestDto dto);
    @Mapping(target = "idProducto", source = "idProducto")
    OrdenProduccionResponseDto toResponseDto(OrdenProduccion ordenProduccion);
}
