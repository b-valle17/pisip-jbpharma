package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class IndicadorKpiRequestDto {

	private int idKpi;

	@NotBlank
	private String nombreIndicador;

	@NotNull
	private BigDecimal valor;

	private Date fechaCalculo;
	private String descripcion;

	public int getIdKpi() { return idKpi; }
	public void setIdKpi(int idKpi) { this.idKpi = idKpi; }

	public String getNombreIndicador() { return nombreIndicador; }
	public void setNombreIndicador(String nombreIndicador) { this.nombreIndicador = nombreIndicador; }

	public BigDecimal getValor() { return valor; }
	public void setValor(BigDecimal valor) { this.valor = valor; }

	public Date getFechaCalculo() { return fechaCalculo; }
	public void setFechaCalculo(Date fechaCalculo) { this.fechaCalculo = fechaCalculo; }

	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
