package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.DictamenLoteEntity;

@Mapper(componentModel = "spring")
public interface IDictamenLoteJpaMapper {

	DictamenLoteEntity toEntity(DictamenLote dictamenLote);

	DictamenLote toDomain(DictamenLoteEntity entity);
}
