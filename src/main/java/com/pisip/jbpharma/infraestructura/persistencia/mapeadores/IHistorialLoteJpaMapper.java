package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.jbpharma.dominio.entidades.HistorialLote;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.HistorialLoteEntity;

@Mapper(componentModel = "spring")
public interface IHistorialLoteJpaMapper {

	@Mapping(source = "ordenProduccion.idOrden", target = "idOrdenProduccion")
	HistorialLote toDomain(HistorialLoteEntity entity);
	HistorialLoteEntity toEntity(HistorialLote historialLote);
	// Convierte de LocalDateTime (JPA) a Date (Dominio)
	default Date map(LocalDateTime localDateTime) {
		if (localDateTime == null) {
			return null;
		}
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	// Convierte de Date (Dominio) a LocalDateTime (JPA)
	default LocalDateTime map(Date date) {
		if (date == null) {
			return null;
		}
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
}
