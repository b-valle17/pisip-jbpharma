package com.pisip.jbpharma.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class OrdenProduccion {

	private Integer idOrden;
	private String numeroLote;
	private BigDecimal cantidadLote;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private String estado;
	private Integer idPlan;
	private Integer idProducto;
	private Integer idUsuario;
	
	public OrdenProduccion() {
		super();
	}

	public OrdenProduccion(Integer idOrden, String numeroLote, BigDecimal cantidadLote, LocalDateTime fechaInicio,
			LocalDateTime fechaFin, String estado, Integer idPlan, Integer idProducto, Integer idUsuario) {
		super();
		this.idOrden = idOrden;
		this.numeroLote = numeroLote;
		this.cantidadLote = cantidadLote;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.idPlan = idPlan;
		this.idProducto = idProducto;
		this.idUsuario = idUsuario;
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

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}