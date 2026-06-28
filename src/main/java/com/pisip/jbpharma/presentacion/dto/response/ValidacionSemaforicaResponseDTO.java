package com.pisip.jbpharma.presentacion.dto.response;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ValidacionSemaforicaResponseDTO {
	
	private Long idValidacion;
	private Long idVariable;
	private Long idParametro;
	private String resultado;
	private String mensaje;
	private LocalDateTime fechaValidacion;

}
