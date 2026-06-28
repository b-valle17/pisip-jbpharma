package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoLaboratorioEntity;

@Mapper(componentModel = "Spring")
public interface iEnsayoLaboratoriojpaMapper {
	
	EnsayoLaboratorio toDominio(EnsayoLaboratorioEntity entity);
	EnsayoLaboratorioEntity toEntity(EnsayoLaboratorio ensayoLaboratorio);

}
