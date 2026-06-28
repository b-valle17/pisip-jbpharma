package com.pisip.jbpharma.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ValidacionSemaforicaRequestDTO {
	
	@NotBlank
	private Long idValidacion;
	@NotBlank
	private Long idVariable;
	@NotBlank
	private Long idParametro;
	@NotBlank
	private String resultado;
	@NotBlank
	private String mensaje;
	@NotBlank
	private LocalDateTime fechaValidacion;

}
