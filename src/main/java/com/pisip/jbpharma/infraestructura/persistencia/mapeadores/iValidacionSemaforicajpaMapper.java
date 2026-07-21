package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ValidacionSemaforicaEntity;

@Mapper(componentModel = "spring")
public interface iValidacionSemaforicajpaMapper {
    @Mapping(source = "fkEnsayoVariableEntity.idVariable", target = "idVariable")
    @Mapping(source = "fkParametroCalidadEntity.idParametro", target = "idParametro")
    ValidacionSemaforica toDominio(ValidacionSemaforicaEntity entity);

    @Mapping(source = "idVariable", target = "fkEnsayoVariableEntity.idVariable")
    @Mapping(source = "idParametro", target = "fkParametroCalidadEntity.idParametro")
    @Mapping(target = "listaAlertas", ignore = true)
    ValidacionSemaforicaEntity toEntity(ValidacionSemaforica validacionSemaforica);
}
