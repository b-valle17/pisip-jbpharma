package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.HistorialLote;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.HistorialLoteEntity;

@Mapper(componentModel = "spring")
public interface IHistorialLoteJpaMapper {

	HistorialLoteEntity toEntity(HistorialLote historialLote);

	HistorialLote toDomain(HistorialLoteEntity entity);
}
