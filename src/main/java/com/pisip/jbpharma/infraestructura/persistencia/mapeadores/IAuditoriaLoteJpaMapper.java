package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.AuditoriaLoteEntity;

@Mapper(componentModel = "spring")
public interface IAuditoriaLoteJpaMapper {

	AuditoriaLoteEntity toEntity(AuditoriaLote auditoriaLote);

	AuditoriaLote toDomain(AuditoriaLoteEntity auditoriaLoteEntity);
}
