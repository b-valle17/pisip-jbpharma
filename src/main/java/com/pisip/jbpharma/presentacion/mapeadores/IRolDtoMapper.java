package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.Rol;
import com.pisip.jbpharma.presentacion.dto.request.RolRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.RolResponseDto;

@Mapper(componentModel = "spring")
public interface IRolDtoMapper {

	Rol toDomain(RolRequestDto dto);

	RolResponseDto toResponseDto(Rol rol);
}