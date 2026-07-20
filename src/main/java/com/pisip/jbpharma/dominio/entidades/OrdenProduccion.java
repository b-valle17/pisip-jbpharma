package com.pisip.jbpharma.dominio.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class OrdenProduccion {

	private Integer idOrden;
	private String numeroLote;
	private BigDecimal cantidadLote;
	private Date fechaInicio;
	private Date fechaFin;
	private String estado;
	
	public OrdenProduccion() {
		super();
	}

	public OrdenProduccion(Integer idOrden, String numeroLote, BigDecimal cantidadLote, Date fechaInicio, Date fechaFin,
			String estado) {
		super();
		this.idOrden = idOrden;
		this.numeroLote = numeroLote;
		this.cantidadLote = cantidadLote;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
	}

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public BigDecimal getCantidadLote() {
		return cantidadLote;
	}

	public void setCantidadLote(BigDecimal cantidadLote) {
		this.cantidadLote = cantidadLote;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}