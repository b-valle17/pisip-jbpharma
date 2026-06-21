package com.pisip.jbpharma.dominio.entidades;

import java.util.Date;

public class PlanProduccion {
	
	private int idPlan;
	private String codigoPlan;
	private int mes;
	private int anio;
	private Date fechaEmision;
	private String estado;
	private String descripcion;
	
	public PlanProduccion() {
		super();

	}

	public PlanProduccion(int idPlan, String codigoPlan, int mes, int anio, Date fechaEmision, String estado,
			String descripcion) {
		super();
		this.idPlan = idPlan;
		this.codigoPlan = codigoPlan;
		this.mes = mes;
		this.anio = anio;
		this.fechaEmision = fechaEmision;
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getCodigoPlan() {
		return codigoPlan;
	}

	public void setCodigoPlan(String codigoPlan) {
		this.codigoPlan = codigoPlan;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
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

}
