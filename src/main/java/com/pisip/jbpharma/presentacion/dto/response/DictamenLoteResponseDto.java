package com.pisip.jbpharma.presentacion.dto.response;

import java.sql.Date;

public class DictamenLoteResponseDto {

	private int idDictamen;
	private int idOrdenProduccion;
	private int idUsuarioInspector;
	private Date fechaDictamen;
	private String estado;
	private String observaciones;

	// Datos del ensayo de laboratorio asociado al lote (si ya existe). Nulos si aun no hay ensayo registrado.
	private Long idEnsayo;
	private String codigoEnsayo;
	private String estadoEnsayo;
	private String observacionEnsayo;

	public int getIdDictamen() { return idDictamen; }
	public void setIdDictamen(int idDictamen) { this.idDictamen = idDictamen; }

	public int getIdOrdenProduccion() { return idOrdenProduccion; }
	public void setIdOrdenProduccion(int idOrdenProduccion) { this.idOrdenProduccion = idOrdenProduccion; }

	public int getIdUsuarioInspector() { return idUsuarioInspector; }
	public void setIdUsuarioInspector(int idUsuarioInspector) { this.idUsuarioInspector = idUsuarioInspector; }

	public Date getFechaDictamen() { return fechaDictamen; }
	public void setFechaDictamen(Date fechaDictamen) { this.fechaDictamen = fechaDictamen; }

	public String getEstado() { return estado; }
	public void setEstado(String estado) { this.estado = estado; }

	public String getObservaciones() { return observaciones; }
	public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

	public Long getIdEnsayo() { return idEnsayo; }
	public void setIdEnsayo(Long idEnsayo) { this.idEnsayo = idEnsayo; }

	public String getCodigoEnsayo() { return codigoEnsayo; }
	public void setCodigoEnsayo(String codigoEnsayo) { this.codigoEnsayo = codigoEnsayo; }

	public String getEstadoEnsayo() { return estadoEnsayo; }
	public void setEstadoEnsayo(String estadoEnsayo) { this.estadoEnsayo = estadoEnsayo; }

	public String getObservacionEnsayo() { return observacionEnsayo; }
	public void setObservacionEnsayo(String observacionEnsayo) { this.observacionEnsayo = observacionEnsayo; }
}
