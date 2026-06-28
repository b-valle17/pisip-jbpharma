package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;
import com.pisip.jbpharma.presentacion.dto.request.ValidacionSemaforicaRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.ValidacionSemaforicaResponseDTO;

@Mapper(componentModel = "spring")
public interface iValidacionSemaforicaDtoMapper {
	
	ValidacionSemaforica toDomain(ValidacionSemaforicaRequestDTO dto);
	ValidacionSemaforicaResponseDTO toResponseDto(ValidacionSemaforica validacionSemaforicapojo);

}
