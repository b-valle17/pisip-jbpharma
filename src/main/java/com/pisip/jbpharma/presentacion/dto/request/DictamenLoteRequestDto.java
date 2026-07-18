package com.pisip.jbpharma.presentacion.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DictamenLoteRequestDto {

	@NotNull
	private int idOrdenProduccion;

	@NotNull
	private int idUsuarioInspector;

	@NotNull
	private Date fechaDictamen;

	@NotBlank
	private String estado;

	@NotBlank
	private String observaciones;

	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}

	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}

	public int getIdUsuarioInspector() {
		return idUsuarioInspector;
	}

	public void setIdUsuarioInspector(int idUsuarioInspector) {
		this.idUsuarioInspector = idUsuarioInspector;
	}

	public Date getFechaDictamen() {
		return fechaDictamen;
	}

	public void setFechaDictamen(Date fechaDictamen) {
		this.fechaDictamen = fechaDictamen;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
