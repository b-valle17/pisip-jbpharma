package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoLaboratorioEntity;

@Mapper(componentModel = "spring")
public interface iEnsayoLaboratoriojpaMapper {
    @Mapping(source = "ordenProduccion.idOrden", target = "idOrden")
    @Mapping(source = "producto.idProducto", target = "idProducto")
    EnsayoLaboratorio toDominio(EnsayoLaboratorioEntity entity);

    @Mapping(source = "idOrden", target = "ordenProduccion.idOrden")
    @Mapping(source = "idProducto", target = "producto.idProducto")
    @Mapping(target = "listaEnsayos", ignore = true)
    EnsayoLaboratorioEntity toEntity(EnsayoLaboratorio ensayoLaboratorio);
}
