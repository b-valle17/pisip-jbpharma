package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.InformeAuditoriaEntity;

@Mapper(componentModel = "spring")
public interface IInformeAuditoriaJpaMapper {

	@Mapping(source = "auditoria.idAuditoria", target = "idAuditoria")
	InformeAuditoria toDomain(InformeAuditoriaEntity entity);
<<<<<<< Updated upstream
=======

	@Mapping(source = "idAuditoria", target = "auditoria.idAuditoria")
	InformeAuditoriaEntity toEntity(InformeAuditoria informeAuditoria);

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
>>>>>>> Stashed changes
}
