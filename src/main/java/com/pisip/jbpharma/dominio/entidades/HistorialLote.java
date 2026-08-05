package com.pisip.jbpharma.dominio.entidades;

import java.sql.Date;

public class HistorialLote {

	private Integer idHistorial;
	private int idOrdenProduccion;
	private Date fechaEvento;
	private String accion;
	private String descripcion;
	public Integer getIdHistorial() {
		return idHistorial;
	}
	public void setIdHistorial(Integer idHistorial) {
		this.idHistorial = idHistorial;
	}
	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}
	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}
	public Date getFechaEvento() {
		return fechaEvento;
	}
	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public HistorialLote(Integer idHistorial, int idOrdenProduccion, Date fechaEvento, String accion, String descripcion) {
		super();
		this.idHistorial = idHistorial;
		this.idOrdenProduccion = idOrdenProduccion;
		this.fechaEvento = fechaEvento;
		this.accion = accion;
		this.descripcion = descripcion;
	}
	public HistorialLote() {
		super();

	}
	
	
}
