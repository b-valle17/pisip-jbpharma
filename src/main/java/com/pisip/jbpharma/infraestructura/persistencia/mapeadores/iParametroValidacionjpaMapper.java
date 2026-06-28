package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.ParametroValidacion;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ParametroValidacionEntity;

@Mapper(componentModel = "Spring")
public interface iParametroValidacionjpaMapper {
	
	ParametroValidacion toDominio(ParametroValidacionEntity entity);
	ParametroValidacionEntity toEntity(ParametroValidacion parametroValidacion);

}
