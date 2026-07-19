package com.pisip.jbpharma.dominio.entidades;

import java.time.LocalDateTime;

public class ValidacionSemaforica {

	private Long idValidacion;
	private Long idVariable;
	private Integer idParametro;
	private String resultado;
	private String mensaje;
	private LocalDateTime fechaValidacion;
	public ValidacionSemaforica() {
		super();
	}
	public ValidacionSemaforica(Long idValidacion, Long idVariable, Integer idParametro, String resultado, String mensaje,
			LocalDateTime fechaValidacion) {
		super();
		this.idValidacion = idValidacion;
		this.idVariable = idVariable;
		this.idParametro = idParametro;
		this.resultado = resultado;
		this.mensaje = mensaje;
		this.fechaValidacion = fechaValidacion;
	}
	public Long getIdValidacion() {
		return idValidacion;
	}
	public void setIdValidacion(Long idValidacion) {
		this.idValidacion = idValidacion;
	}
	public Long getIdVariable() {
		return idVariable;
	}
	public void setIdVariable(Long idVariable) {
		this.idVariable = idVariable;
	}
	public Integer getIdParametro() {
		return idParametro;
	}
	public void setIdParametro(Integer idParametro) {
		this.idParametro = idParametro;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public LocalDateTime getFechaValidacion() {
		return fechaValidacion;
	}
	public void setFechaValidacion(LocalDateTime fechaValidacion) {
		this.fechaValidacion = fechaValidacion;
	}
	
	
	
}
