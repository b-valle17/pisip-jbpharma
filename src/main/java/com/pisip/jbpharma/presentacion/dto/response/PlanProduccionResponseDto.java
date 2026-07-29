package com.pisip.jbpharma.presentacion.dto.response;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class PlanProduccionResponseDto {
	
	private Integer idPlan;
	private String codigoPlan;
	private Integer mes;
	private Integer anio;
	private LocalDateTime fechaEmision;
	private String estado;
	private String descripcion;
	private Integer cantidadLotesEstimada;
	@JsonProperty("idUsuario")
    @JsonAlias({"fkUsuario", "fk_usuario", "id_usuario", "idUsuario"})
    private Integer idUsuario;
	
	private String nombreUsuario;
	private UsuarioResponseDTO usuario;
	}
