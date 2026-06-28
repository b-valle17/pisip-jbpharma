package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.ParametroValidacion;
import com.pisip.jbpharma.presentacion.dto.request.ParametroValidacionRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.ParametroValidacionResponseDTO;

@Mapper(componentModel = "spring")
public interface iParametroValidacionDtoMapper {
	
	ParametroValidacion toDomain(ParametroValidacionRequestDTO dto);
	ParametroValidacionResponseDTO toResponseDto(ParametroValidacion parametroValidacionpojo);

}
