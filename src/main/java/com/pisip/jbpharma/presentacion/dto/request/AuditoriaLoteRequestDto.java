package com.pisip.jbpharma.presentacion.dto.request;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuditoriaLoteRequestDto {

	@NotNull
	private int idOrdenProduccion;

	@NotNull
	private int idUsuarioAuditor;

	@NotNull
	private Date fechaAuditoria;

	@NotBlank
	private String resultado;

	@NotBlank
	private String observaciones;

	public int getIdOrdenProduccion() {
		return idOrdenProduccion;
	}

	public void setIdOrdenProduccion(int idOrdenProduccion) {
		this.idOrdenProduccion = idOrdenProduccion;
	}

	public int getIdUsuarioAuditor() {
		return idUsuarioAuditor;
	}

	public void setIdUsuarioAuditor(int idUsuarioAuditor) {
		this.idUsuarioAuditor = idUsuarioAuditor;
	}

	public Date getFechaAuditoria() {
		return fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
