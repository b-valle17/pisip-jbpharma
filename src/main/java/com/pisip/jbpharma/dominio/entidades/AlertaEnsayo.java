package com.pisip.jbpharma.dominio.entidades;

import java.time.LocalDateTime;

public class AlertaEnsayo {

	private Long idAlerta;
	private Long idValidacion;
	private String tipoAlerta;
	private String destinatario;
	private String asunto;
	private String mensaje;
	private String estadoEnvio;
	private LocalDateTime fechaGeneracion;
	private LocalDateTime fechaEnvio;
	
	public AlertaEnsayo() {
		super();
	}

	public AlertaEnsayo(Long idAlerta, Long idValidacion, String tipoAlerta, String destinatario, String asunto,
			String mensaje, String estadoEnvio, LocalDateTime fechaGeneracion, LocalDateTime fechaEnvio) {
		super();
		this.idAlerta = idAlerta;
		this.idValidacion = idValidacion;
		this.tipoAlerta = tipoAlerta;
		this.destinatario = destinatario;
		this.asunto = asunto;
		this.mensaje = mensaje;
		this.estadoEnvio = estadoEnvio;
		this.fechaGeneracion = fechaGeneracion;
		this.fechaEnvio = fechaEnvio;
	}

	public Long getIdAlerta() {
		return idAlerta;
	}

	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}

	public Long getIdValidacion() {
		return idValidacion;
	}

	public void setIdValidacion(Long idValidacion) {
		this.idValidacion = idValidacion;
	}

	public String getTipoAlerta() {
		return tipoAlerta;
	}

	public void setTipoAlerta(String tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEstadoEnvio() {
		return estadoEnvio;
	}

	public void setEstadoEnvio(String estadoEnvio) {
		this.estadoEnvio = estadoEnvio;
	}

	public LocalDateTime getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(LocalDateTime fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	
}

