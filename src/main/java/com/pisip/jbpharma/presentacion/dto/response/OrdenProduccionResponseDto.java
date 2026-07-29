package com.pisip.jbpharma.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OrdenProduccionResponseDto {
	
	private Integer idOrden;
	private Integer idPlan;
	private Integer idProducto;
	
	@JsonProperty("idUsuario")
	@JsonAlias({"fkUsuario", "fk_usuario", "id_usuario", "idUsuario"})
	private Integer idUsuario;
	
	private String numeroLote;
	private BigDecimal cantidadLote;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private String estado;
	private String codigoPlan;
	private String nombreProducto;
	private String nombreUsuario;
}