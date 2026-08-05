package com.pisip.jbpharma.dominio.entidades;

import java.time.LocalDate;

public class DictamenLote {

	private Integer idDictamen;
	private int idOrdenProduccion;
	private int idUsuarioInspector;
	private LocalDate fechaDictamen;
	private String estado;
	private String observaciones;

	public DictamenLote() {
		super();
	}

	public DictamenLote(Integer idDictamen, int idOrdenProduccion, int idUsuarioInspector, LocalDate fechaDictamen,
			String estado, String observaciones) {
		super();
		this.idDictamen = idDictamen;
		this.idOrdenProduccion = idOrdenProduccion;
		this.idUsuarioInspector = idUsuarioInspector;
		this.fechaDictamen = fechaDictamen;
		this.estado = estado;
		this.observaciones = observaciones;
	}

	public Integer getIdDictamen() {
		return idDictamen;
	}

	public void setIdDictamen(Integer idDictamen) {
		this.idDictamen = idDictamen;
	}

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

	public LocalDate getFechaDictamen() {
		return fechaDictamen;
	}

	public void setFechaDictamen(LocalDate fechaDictamen) {
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
