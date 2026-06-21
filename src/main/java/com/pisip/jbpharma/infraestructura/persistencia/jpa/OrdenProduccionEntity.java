package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orden_produccion")
public class OrdenProduccionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_orden")
	private int idOrden;
	@Column(name = "numero_lote", nullable = false, unique = true, length = 50)
	private String numeroLote;
	@Column(name = "cantidad_lote", nullable = false, precision = 12, scale = 3)
	private BigDecimal cantidadLote;
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	@Column(name = "fecha_final")
	private Date fechaFin;
	private String estado;

}
