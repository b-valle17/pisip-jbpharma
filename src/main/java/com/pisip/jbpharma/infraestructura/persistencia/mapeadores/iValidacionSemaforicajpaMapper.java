package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ValidacionSemaforicaEntity;

@Mapper(componentModel = "Spring")
public interface iValidacionSemaforicajpaMapper {
	
	ValidacionSemaforica toDominio(ValidacionSemaforicaEntity entity);
	ValidacionSemaforicaEntity toEntity(ValidacionSemaforica validacionSemaforica);

}
