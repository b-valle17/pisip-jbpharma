package com.pisip.jbpharma.presentacion.dto.response;

import java.sql.Date;
import java.time.LocalDateTime;

public class HistorialLoteResponseDto {

	private int idHistorial;
	private int idOrdenProduccion;
	private LocalDateTime fechaEvento;
	private String accion;
	private String descripcion;

	// Estado final del lote (ACEPTADO/RECHAZADO), tomado del ultimo dictamen del mismo lote. Puede ser null
	// si el lote todavia no tiene un dictamen registrado.
	private String estadoLote;

	public int getIdHistorial() { return idHistorial; }
	public void setIdHistorial(int idHistorial) { this.idHistorial = idHistorial; }

	public int getIdOrdenProduccion() { return idOrdenProduccion; }
	public void setIdOrdenProduccion(int idOrdenProduccion) { this.idOrdenProduccion = idOrdenProduccion; }

	public LocalDateTime getFechaEvento() { return fechaEvento; }
	public void setFechaEvento(LocalDateTime fechaEvento) { this.fechaEvento = fechaEvento; }

	public String getAccion() { return accion; }
	public void setAccion(String accion) { this.accion = accion; }

	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

	public String getEstadoLote() { return estadoLote; }
	public void setEstadoLote(String estadoLote) { this.estadoLote = estadoLote; }
}
