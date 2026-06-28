package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;
import com.pisip.jbpharma.presentacion.dto.request.AlertaEnsayoRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.AlertaEnsayoResponseDTO;


@Mapper(componentModel = "spring")
public interface iAlertaEnsayoDtoMapper {

	AlertaEnsayo toDomain(AlertaEnsayoRequestDTO dto);
	AlertaEnsayoResponseDTO toResponseDto(AlertaEnsayo alertaEnsayopojo);
}
