package com.pisip.jbpharma.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlanProduccionRequestDto {
	
	@NotNull
	private int idPlan;
	@NotBlank
	private String codigoPlan;
	@NotBlank
	private int mes;
	@NotBlank
	private int anio;
	@NotBlank
	private Date fechaEmision;
	@NotBlank
	private String estado;
	@NotBlank
	private String descripcion;
}
