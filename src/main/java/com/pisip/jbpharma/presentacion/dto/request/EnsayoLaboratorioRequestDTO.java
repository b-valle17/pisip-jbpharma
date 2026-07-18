package com.pisip.jbpharma.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EnsayoLaboratorioRequestDTO {
	
	@NotBlank
	private Long idEnsayo;
	@NotBlank
	private Integer idLote;
	@NotBlank
	private Integer idProducto;
	@NotBlank
	private String codigoEnsayo;
	@NotBlank
	private LocalDateTime fechaEnsayo;
	@NotBlank
	private String responsable;
	@NotBlank
	private String observacion;
	@NotBlank
	private String estado;
	@NotBlank
	private LocalDateTime creadoEn;

}
