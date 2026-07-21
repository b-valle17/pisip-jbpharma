package com.pisip.jbpharma.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductoRequestDto {

	private Integer idProducto;
	
	@NotBlank
	private String nombreProducto;

	@NotBlank
	private String descripcion;
}