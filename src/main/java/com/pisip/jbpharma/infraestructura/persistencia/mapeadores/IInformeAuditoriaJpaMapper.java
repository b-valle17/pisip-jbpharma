package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.InformeAuditoriaEntity;

@Mapper(componentModel = "spring")
public interface IInformeAuditoriaJpaMapper {

	InformeAuditoriaEntity toEntity(InformeAuditoria informeAuditoria);

	InformeAuditoria toDomain(InformeAuditoriaEntity informeAuditoriaEntity);
}
