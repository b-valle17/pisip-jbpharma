package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.InformeAuditoriaEntity;

@Mapper(componentModel = "spring")
public interface IInformeAuditoriaJpaMapper {

	InformeAuditoriaEntity toEntity(InformeAuditoria informeAuditoria);

	InformeAuditoria toDomain(InformeAuditoriaEntity entity);

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