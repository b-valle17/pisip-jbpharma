package com.pisip.jbpharma.dominio.entidades;

import java.time.LocalDateTime;

public class EnsayoLaboratorio {

	private Long idEnsayo;
	private Integer idLote;
	private Integer idProducto;
	private String codigoEnsayo;
	private LocalDateTime fechaEnsayo;
	private String responsable;
	private String observacion;
	private String estado;
	private LocalDateTime creadoEn;
	
	public EnsayoLaboratorio() {
		super();
	}

	public EnsayoLaboratorio(Long idEnsayo, Integer idLote, Integer idProducto, String codigoEnsayo,
			LocalDateTime fechaEnsayo, String responsable, String observacion, String estado, LocalDateTime creadoEn) {
		super();
		this.idEnsayo = idEnsayo;
		this.idLote = idLote;
		this.idProducto = idProducto;
		this.codigoEnsayo = codigoEnsayo;
		this.fechaEnsayo = fechaEnsayo;
		this.responsable = responsable;
		this.observacion = observacion;
		this.estado = estado;
		this.creadoEn = creadoEn;
	}

	public Long getIdEnsayo() {
		return idEnsayo;
	}

	public void setIdEnsayo(Long idEnsayo) {
		this.idEnsayo = idEnsayo;
	}

	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoEnsayo() {
		return codigoEnsayo;
	}

	public void setCodigoEnsayo(String codigoEnsayo) {
		this.codigoEnsayo = codigoEnsayo;
	}

	public LocalDateTime getFechaEnsayo() {
		return fechaEnsayo;
	}

	public void setFechaEnsayo(LocalDateTime fechaEnsayo) {
		this.fechaEnsayo = fechaEnsayo;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	
}

