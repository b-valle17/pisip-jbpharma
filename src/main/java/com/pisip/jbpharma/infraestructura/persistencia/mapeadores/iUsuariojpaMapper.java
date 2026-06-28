package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.UsuarioEntity;

@Mapper(componentModel = "Spring")
public interface iUsuariojpaMapper {
	
	Usuario toDominio(UsuarioEntity entity);
	UsuarioEntity toEntity(Usuario usuario);

}
