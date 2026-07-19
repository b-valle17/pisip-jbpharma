package com.pisip.jbpharma.dominio.entidades;

import java.time.LocalDateTime;

public class EnsayoLaboratorio {

	private Long idEnsayo;
	private Integer idOrden;
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

	public EnsayoLaboratorio(Long idEnsayo, Integer idOrden, Integer idProducto, String codigoEnsayo,
			LocalDateTime fechaEnsayo, String responsable, String observacion, String estado, LocalDateTime creadoEn) {
		super();
		this.idEnsayo = idEnsayo;
		this.idOrden = idOrden;
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

	public Integer getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(Integer idOrden) {
		this.idOrden = idOrden;
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

