package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;
import com.pisip.jbpharma.presentacion.dto.request.InformeAuditoriaRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.InformeAuditoriaResponseDto;

@Mapper(componentModel = "spring")
public interface IInformeAuditoriaDtoMapper {

	InformeAuditoria toDomain(InformeAuditoriaRequestDto dto);

	InformeAuditoriaResponseDto toResponseDto(InformeAuditoria informeAuditoria);
}
