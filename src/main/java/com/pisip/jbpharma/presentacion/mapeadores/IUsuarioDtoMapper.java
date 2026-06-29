package com.pisip.jbpharma.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.presentacion.dto.request.UsuarioRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.UsuarioResponseDto;

@Mapper(componentModel = "spring")
public interface IUsuarioDtoMapper {

	Usuario toDomain(UsuarioRequestDto dto);

	UsuarioResponseDto toResponseDto(Usuario usuario);
}