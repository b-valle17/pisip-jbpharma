package com.pisip.jbpharma.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ParametroValidacionResponseDTO {
	
	private Long idParametro;
	private Integer idProducto;
	private String nombreVariable;
	private BigDecimal valorMinimo;
	private BigDecimal valorMaximo;
	private String unidadMedida;
	private Boolean activo;
	private LocalDateTime creadoEn;

}
