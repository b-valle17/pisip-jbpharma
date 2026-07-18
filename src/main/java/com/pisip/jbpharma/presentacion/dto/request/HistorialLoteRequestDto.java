package com.pisip.jbpharma.presentacion.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class HistorialLoteRequestDto {

	@NotNull
	private int idOrdenProduccion;

	@NotNull
	private Date fechaEvento;

	@NotBlank
	private String accion;

	@NotBlank
	private String descripcion;

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
}
