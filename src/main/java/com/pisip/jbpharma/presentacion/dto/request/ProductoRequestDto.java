package com.pisip.jbpharma.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ProductoRequestDto {

	@NotBlank
	private String nombreProducto;

	@NotBlank
	private String descripcion;

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}