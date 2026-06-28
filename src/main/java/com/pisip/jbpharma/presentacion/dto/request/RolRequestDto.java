package com.pisip.jbpharma.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class RolRequestDto {

	@NotBlank
	private int idRol;
	
	@NotBlank
	private String nombreRol;

	@NotBlank
	private String descripcion;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}