package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.DictamenLoteEntity;

@Mapper(componentModel = "spring")
public interface IDictamenLoteJpaMapper {

	DictamenLoteEntity toEntity(DictamenLote dictamenLote);

	DictamenLote toDomain(DictamenLoteEntity entity);

	// Resuelve el error al pasar de la Entidad (LocalDateTime) al Dominio (Date)
	default Date map(LocalDateTime localDateTime) {
		if (localDateTime == null) {
			return null;
		}
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	// Resuelve el mapeo inverso al guardar del Dominio (Date) a la Entidad (LocalDateTime)
	default LocalDateTime map(Date date) {
		if (date == null) {
			return null;
		}
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
}
