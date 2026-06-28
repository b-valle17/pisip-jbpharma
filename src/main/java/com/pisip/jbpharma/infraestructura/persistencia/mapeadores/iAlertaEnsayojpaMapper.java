package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.AlertaEnsayoEntity;

@Mapper(componentModel = "Spring")
public interface iAlertaEnsayojpaMapper {
	
	AlertaEnsayo toDominio(AlertaEnsayoEntity entity);
	AlertaEnsayoEntity toEntity(AlertaEnsayo alertaEnsayo);
	

}
