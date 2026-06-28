package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoVariableEntity;

@Mapper(componentModel = "Spring")
public interface iEnsayoVariablejpaMapper {

	EnsayoVariable toDominio(EnsayoVariableEntity entity);
	EnsayoVariableEntity toEntity(EnsayoVariable ensayoVariable);
}
