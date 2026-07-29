package com.pisip.jbpharma.presentacion.dto.request;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DictamenLoteRequestDto {

	private Integer idDictamen;

	@NotNull
	private int idOrdenProduccion;

	@NotNull
	private int idUsuarioInspector;

	private Date fechaDictamen;
	private String estado;
	private String observaciones;
}
