package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;
import com.pisip.jbpharma.presentacion.dto.request.EnsayoVariableRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.EnsayoVariableResponseDTO;



@Mapper(componentModel = "spring")
public interface iEnsayoVariableDtoMapper {
	
	EnsayoVariable toDomain(EnsayoVariableRequestDTO dto);
	EnsayoVariableResponseDTO toResponseDto(EnsayoVariable ensayoVariablepojo);

}
