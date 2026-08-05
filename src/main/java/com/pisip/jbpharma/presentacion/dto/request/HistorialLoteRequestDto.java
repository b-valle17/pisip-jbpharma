package com.pisip.jbpharma.presentacion.dto.request;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class HistorialLoteRequestDto {

	private Integer idHistorial;

	@NotNull
	private int idOrdenProduccion;

	private LocalDateTime fechaEvento;
	private String accion;
	private String descripcion;

	public Integer getIdHistorial() { return idHistorial; }
	public void setIdHistorial(Integer idHistorial) { this.idHistorial = idHistorial; }

	public int getIdOrdenProduccion() { return idOrdenProduccion; }
	public void setIdOrdenProduccion(int idOrdenProduccion) { this.idOrdenProduccion = idOrdenProduccion; }

	public LocalDateTime getFechaEvento() { return fechaEvento; }
	public void setFechaEvento(LocalDateTime fechaEvento) { this.fechaEvento = fechaEvento; }

	public String getAccion() { return accion; }
	public void setAccion(String accion) { this.accion = accion; }

	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
