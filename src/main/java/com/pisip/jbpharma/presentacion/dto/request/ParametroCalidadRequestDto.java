package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParametroCalidadRequestDto {

	@NotNull
	private int idParametro;
	
	@NotBlank
	private String nombreParametro;

	@NotNull
	private BigDecimal limiteMinimo;

	@NotNull
	private BigDecimal limiteMaximo;

	@NotBlank
	private String unidadMedida;

	private Date fechaConfiguracion;
	
	private int idProducto;
}