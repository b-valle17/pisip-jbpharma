package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.presentacion.dto.request.UsuarioRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.UsuarioResponseDTO;

@Mapper(componentModel = "spring")
public interface iUsuarioDtoMapper {

	Usuario toDomain(UsuarioRequestDTO dto);
	UsuarioResponseDTO toResponseDto(Usuario usuariopojo);
}
