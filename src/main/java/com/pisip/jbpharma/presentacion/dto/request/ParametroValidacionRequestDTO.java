package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ParametroValidacionRequestDTO {
	
	@NotBlank
	private Long idParametro;
	@NotBlank
	private Integer idProducto;
	@NotBlank
	private String nombreVariable;
	@NotBlank
	private BigDecimal valorMinimo;
	@NotBlank
	private BigDecimal valorMaximo;
	@NotBlank
	private String unidadMedida;
	@NotBlank
	private Boolean activo;
	@NotBlank
	private LocalDateTime creadoEn;

}
