package com.pisip.jbpharma.presentacion.dto.response;

import java.util.Date;

import lombok.Data;
@Data
public class PlanProduccionResponseDto {
	
	private Integer idPlan;
	private Integer Usuario;
	private String codigoPlan;
	private Integer mes;
	private Integer anio;
	private Date fechaEmision;
	private String estado;
	private String descripcion;
	
	}
