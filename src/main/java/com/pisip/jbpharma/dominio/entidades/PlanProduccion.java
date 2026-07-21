package com.pisip.jbpharma.dominio.entidades;

import java.util.Date;

public class PlanProduccion {
	
	private Integer idPlan; 
	private String codigoPlan;
	private Integer mes;    
	private Integer anio;   
	private Date fechaEmision;
	private String estado;
	private String descripcion;
	private Integer idUsuario;
	
	public PlanProduccion() {
		super();
	}

	public PlanProduccion(Integer idPlan, String codigoPlan, Integer mes, Integer anio, Date fechaEmision,
			String estado, String descripcion, Integer idUsuario) {
		super();
		this.idPlan = idPlan;
		this.codigoPlan = codigoPlan;
		this.mes = mes;
		this.anio = anio;
		this.fechaEmision = fechaEmision;
		this.estado = estado;
		this.descripcion = descripcion;
		this.idUsuario = idUsuario;
	}

	public Integer getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(Integer idPlan) {
		this.idPlan = idPlan;
	}

	public String getCodigoPlan() {
		return codigoPlan;
	}

	public void setCodigoPlan(String codigoPlan) {
		this.codigoPlan = codigoPlan;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}