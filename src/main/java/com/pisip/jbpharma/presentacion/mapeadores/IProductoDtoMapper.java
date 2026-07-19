package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.Producto;
import com.pisip.jbpharma.presentacion.dto.request.ProductoRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.ProductoResponseDto;

@Mapper(componentModel = "spring")
public interface IProductoDtoMapper {

	Producto toDomain(ProductoRequestDto dto);

	ProductoResponseDto toResponseDto(Producto producto);
}