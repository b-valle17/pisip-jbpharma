package com.pisip.jbpharma.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.pisip.jbpharma.dominio.entidades.Producto;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ProductoEntity;

@Mapper(componentModel = "spring")
public interface IProductoJpaMapper {

	ProductoEntity toEntity(Producto producto);

	Producto toDomain(ProductoEntity productoEntity);
}