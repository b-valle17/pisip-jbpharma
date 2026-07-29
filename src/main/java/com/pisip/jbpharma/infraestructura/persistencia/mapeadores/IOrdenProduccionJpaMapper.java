package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.OrdenProduccionEntity;

@Mapper(componentModel = "spring")
public interface IOrdenProduccionJpaMapper {

	@Mapping(source = "idUsuario", target = "usuario.idUsuario")
	@Mapping(source = "idPlan", target = "planProduccion.idPlan")
	@Mapping(source = "idProducto", target = "producto.idProducto")
	OrdenProduccionEntity toEntity(OrdenProduccion ordenProduccion);

	@Mapping(source = "usuario.idUsuario", target = "idUsuario")
	@Mapping(source = "planProduccion.idPlan", target = "idPlan")
	@Mapping(source = "producto.idProducto", target = "idProducto")
	OrdenProduccion toDomain(OrdenProduccionEntity ordenProduccionEntity);
}