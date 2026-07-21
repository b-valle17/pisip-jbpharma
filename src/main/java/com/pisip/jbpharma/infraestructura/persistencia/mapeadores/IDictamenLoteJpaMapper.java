package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.DictamenLoteEntity;

@Mapper(componentModel = "spring")
public interface IDictamenLoteJpaMapper {

	@Mapping(source = "ordenProduccion.idOrden", target = "idOrdenProduccion")
	@Mapping(source = "usuarioInspector.idUsuario", target = "idUsuarioInspector")
	DictamenLote toDomain(DictamenLoteEntity entity);
<<<<<<< Updated upstream
=======

	@Mapping(source = "idOrdenProduccion", target = "ordenProduccion.idOrden")
	@Mapping(source = "idUsuarioInspector", target = "usuarioInspector.idUsuario")
	DictamenLoteEntity toEntity(DictamenLote dictamenLote);

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
>>>>>>> Stashed changes
}
