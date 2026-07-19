package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "producto")
public class ProductoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
    private String nombreProducto;
    @Column(name = ("descripcion_producto"))
    private String descripcion;

	@OneToMany(mappedBy = "fkProductoEntity")
	private List<ParametroCalidadEntity> listaParametroCalidad;
	
	@OneToMany(mappedBy = "fkProductoEntity")
	private List<OrdenProduccionEntity> ordenproduccion;

}
