package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.pisip.jbpharma.dominio.entidades.AlertaEnsayo;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.AlertaEnsayoEntity;

@Mapper(componentModel = "spring")
public interface iAlertaEnsayojpaMapper {
    @Mapping(source = "fkValidacionSemaforicaEntity.idValidacion", target = "idValidacion")
    AlertaEnsayo toDominio(AlertaEnsayoEntity entity);

    @Mapping(source = "idValidacion", target = "fkValidacionSemaforicaEntity.idValidacion")
    AlertaEnsayoEntity toEntity(AlertaEnsayo alertaEnsayo);
}
