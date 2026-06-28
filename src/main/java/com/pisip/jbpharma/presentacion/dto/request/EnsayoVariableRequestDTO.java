package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnsayoVariableRequestDTO {
	
	@NotBlank
	private Long idVariable;
	@NotBlank
	private Long idEnsayo;
	@NotBlank
	private String nombreVariable;
	@NotBlank
	private BigDecimal valorObtenido;
	@NotBlank
	private String unidadMedida;
	@NotBlank
	private LocalDateTime creadoEn;

}
