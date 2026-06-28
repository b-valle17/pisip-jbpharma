package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.presentacion.dto.request.EnsayoLaboratorioRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.EnsayoLaboratorioResponseDTO;

@Mapper(componentModel = "spring")
public interface iEnsayoLaboratorioDtoMapper {
	
	EnsayoLaboratorio toDomain(EnsayoLaboratorioRequestDTO dto);
	EnsayoLaboratorioResponseDTO toResponseDto(EnsayoLaboratorio ensayoLaboratoriopojo);

}
