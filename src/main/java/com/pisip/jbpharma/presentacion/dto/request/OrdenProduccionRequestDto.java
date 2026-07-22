package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdenProduccionRequestDto {
	
	
	private Integer idOrden;
	private Integer idPlan;
	private Integer idProducto;
	private Integer idUsuario;
	@NotBlank
	private String numeroLote;
	@NotNull(message = "El tamaño o cantidad es obligatorio")
    @DecimalMin(value = "0.1", message = "El valor debe ser mayor a 0")
	private BigDecimal cantidadLote;
	@NotNull
	private Date fechaInicio;
	@NotNull
	private Date fechaFin;
	@NotBlank
	private String estado;
}
