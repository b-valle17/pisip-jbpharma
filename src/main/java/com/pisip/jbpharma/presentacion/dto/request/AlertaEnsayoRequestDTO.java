package com.pisip.jbpharma.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AlertaEnsayoRequestDTO {

	@NotBlank
	private Long idAlerta;
	@NotBlank
	private Long idValidacion;
	@NotBlank
	private String tipoAlerta;
	@NotBlank
	private String destinatario;
	@NotBlank
	private String asunto;
	@NotBlank
	private String mensaje;
	@NotBlank
	private String estadoEnvio;
	@NotBlank
	private LocalDateTime fechaGeneracion;
	@NotBlank
	private LocalDateTime fechaEnvio;
}
