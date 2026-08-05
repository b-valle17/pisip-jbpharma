package com.pisip.jbpharma.presentacion.dto.response;

import java.time.LocalDate;
import java.util.Date;

import lombok.Data;

@Data
public class DictamenLoteResponseDto {

	private Integer idDictamen;
	private int idOrdenProduccion;
	private int idUsuarioInspector;
	private LocalDate fechaDictamen;
	private String estado;
	private String observaciones;

	// Datos del ensayo de laboratorio asociado al lote (si ya existe). Nulos si aun no hay ensayo registrado.
	private Long idEnsayo;
	private String codigoEnsayo;
	private String estadoEnsayo;
	private String observacionEnsayo;
}
