package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoVariableEntity;

@Mapper(componentModel = "spring")
public interface iEnsayoVariablejpaMapper {
    @Mapping(source = "fkEnsayoLaboratorioEntity.idEnsayo", target = "idEnsayo")
    EnsayoVariable toDominio(EnsayoVariableEntity entity);

    @Mapping(source = "idEnsayo", target = "fkEnsayoLaboratorioEntity.idEnsayo")
    @Mapping(target = "listaValidaciones", ignore = true)
    EnsayoVariableEntity toEntity(EnsayoVariable ensayoVariable);
}
