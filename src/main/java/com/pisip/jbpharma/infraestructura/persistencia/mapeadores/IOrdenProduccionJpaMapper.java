package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.OrdenProduccionEntity;

@Mapper(componentModel = "spring")
public interface IOrdenProduccionJpaMapper {

	OrdenProduccionEntity toEntity(OrdenProduccion ordenProduccion);

	OrdenProduccion toDomain(OrdenProduccionEntity ordenProduccionEntity);
}
