package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.AuditoriaLoteEntity;

@Mapper(componentModel = "spring")
public interface IAuditoriaLoteJpaMapper {

	@Mapping(source = "ordenProduccion.idOrden", target = "idOrdenProduccion")
	@Mapping(source = "usuarioAuditor.idUsuario", target = "idUsuarioAuditor")
	AuditoriaLote toDomain(AuditoriaLoteEntity entity);
<<<<<<< Updated upstream
=======

	@Mapping(source = "idOrdenProduccion", target = "ordenProduccion.idOrden")
	@Mapping(source = "idUsuarioAuditor", target = "usuarioAuditor.idUsuario")
	@Mapping(target = "informes", ignore = true)
	AuditoriaLoteEntity toEntity(AuditoriaLote auditoriaLote);

	// Convierte de LocalDateTime (JPA) a Date (Dominio) - Soluciona tu error
	default Date map(LocalDateTime localDateTime) {
		if (localDateTime == null) {
			return null;
		}
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	// Convierte de Date (Dominio) a LocalDateTime (JPA) - Evita el error inverso en toEntity
	default LocalDateTime map(Date date) {
		if (date == null) {
			return null;
		}
		return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
	}
>>>>>>> Stashed changes
}
