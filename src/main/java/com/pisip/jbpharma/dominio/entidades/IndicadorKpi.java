package com.pisip.jbpharma.dominio.entidades;

import java.math.BigDecimal;
import java.sql.Date;

public class IndicadorKpi {
	
	private int idKpi;
	private String nombreIndicador;
	private BigDecimal valor;
	private Date fechaCalculo;
	private String descripcion;
	public int getIdKpi() {
		return idKpi;
	}
	public void setIdKpi(int idKpi) {
		this.idKpi = idKpi;
	}
	public String getNombreIndicador() {
		return nombreIndicador;
	}
	public void setNombreIndicador(String nombreIndicador) {
		this.nombreIndicador = nombreIndicador;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getFechaCalculo() {
		return fechaCalculo;
	}
	public void setFechaCalculo(Date fechaCalculo) {
		this.fechaCalculo = fechaCalculo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public IndicadorKpi(int idKpi, String nombreIndicador, BigDecimal valor, Date fechaCalculo, String descripcion) {
		super();
		this.idKpi = idKpi;
		this.nombreIndicador = nombreIndicador;
		this.valor = valor;
		this.fechaCalculo = fechaCalculo;
		this.descripcion = descripcion;
	}
	public IndicadorKpi() {
		super();

	}
	
	
	
}
