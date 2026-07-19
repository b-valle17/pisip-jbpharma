package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdenProduccionRequestDto {
	
	@NotNull
	private int idOrden;
	@NotBlank
	private String numeroLote;
	@NotNull
	@DecimalMin(value = "0.1", message = "El valor debe ser mayor a 0")
	private BigDecimal cantidadLote;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaInicio;
	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaFin;
	@NotBlank
	private String estado;
}
