package com.pisip.jbpharma.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "indicador_kpi")
public class IndicadorKpiEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idKpi;
	private String nombreIndicador;
	private BigDecimal valor;
	private Date fechaCalculo;
	private String descripcion;
}
