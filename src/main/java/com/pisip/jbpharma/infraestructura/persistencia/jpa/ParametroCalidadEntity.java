package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "parametro_calidad")
public class ParametroCalidadEntity {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idParametro;
	 private String nombreParametro;
	 private BigDecimal limiteMinimo;
	 private BigDecimal limiteMaximo;
	 private String unidadMedida;
	 private Date fechaConfiguracion;

	@ManyToOne
	@JoinColumn(name = "fk_producto")
	private ProductoEntity fkProductoEntity;

}
