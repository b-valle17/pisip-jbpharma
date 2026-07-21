package com.pisip.jbpharma.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlanProduccionRequestDto {
	
	
	private Integer idPlan;
	private Integer idUsuario;
	@NotBlank
	private String codigoPlan;
	@NotNull(message = "El mes es obligatorio") 
	@Min(value = 1)
	@Max(value = 12)
	private Integer mes;
	@NotNull(message = "El año es obligatorio") 
	@Min(value = 2025, message = "El año mínimo es 2025")
	@Max(value = 2027, message = "El año máximo es 2027")
	private Integer anio;
	@NotNull
	private Date fechaEmision;
	@NotBlank
	private String estado;
	@NotBlank
	private String descripcion;
}
