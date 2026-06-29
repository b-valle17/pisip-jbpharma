package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdenProduccionRequestDto {
	
	@NotNull
	private int idOrden;
	@NotBlank
	private String numeroLote;
	@NotBlank
	private BigDecimal cantidadLote;
	@NotBlank
	private Date fechaInicio;
	@NotBlank
	private Date fechaFin;
	@NotBlank
	private String estado;
}
