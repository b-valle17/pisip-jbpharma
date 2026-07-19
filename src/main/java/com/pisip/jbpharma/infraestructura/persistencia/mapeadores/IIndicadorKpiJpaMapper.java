package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.IndicadorKpiEntity;

@Mapper(componentModel = "spring")
public interface IIndicadorKpiJpaMapper {

	IndicadorKpiEntity toEntity(IndicadorKpi indicadorKpi);

	IndicadorKpi toDomain(IndicadorKpiEntity entity);
}
