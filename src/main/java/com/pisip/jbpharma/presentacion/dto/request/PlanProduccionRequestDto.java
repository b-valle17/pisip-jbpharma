package com.pisip.jbpharma.presentacion.dto.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PlanProduccionRequestDto {
	
	@NotNull
	private int idPlan;
	@NotBlank
	private String codigoPlan;
	@NotNull(message = "El mes es obligatorio") 
	@Min(value = 1)
	@Max(value = 12)
	private int mes;
	@NotNull(message = "El año es obligatorio") 
	@Min(value = 2025, message = "El año mínimo es 2025")
	@Max(value = 2027, message = "El año máximo es 2027")
	private int anio;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEmision;
	@NotBlank
	private String estado;
	@NotBlank
	private String descripcion;
}
