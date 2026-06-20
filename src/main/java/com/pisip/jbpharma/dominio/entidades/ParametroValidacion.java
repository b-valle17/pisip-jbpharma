package com.pisip.jbpharma.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ParametroValidacion {

	private Long idParametro;
	private Integer idProducto;
	private String nombreVariable;
	private BigDecimal valorMinimo;
	private BigDecimal valorMaximo;
	private String unidadMedida;
	private Boolean activo;
	private LocalDateTime creadoEn;
	
	public ParametroValidacion() {
		super();
	}

	public ParametroValidacion(Long idParametro, Integer idProducto, String nombreVariable, BigDecimal valorMinimo,
			BigDecimal valorMaximo, String unidadMedida, Boolean activo, LocalDateTime creadoEn) {
		super();
		this.idParametro = idParametro;
		this.idProducto = idProducto;
		this.nombreVariable = nombreVariable;
		this.valorMinimo = valorMinimo;
		this.valorMaximo = valorMaximo;
		this.unidadMedida = unidadMedida;
		this.activo = activo;
		this.creadoEn = creadoEn;
	}

	public Long getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(Long idParametro) {
		this.idParametro = idParametro;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreVariable() {
		return nombreVariable;
	}

	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}

	public BigDecimal getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(BigDecimal valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public BigDecimal getValorMaximo() {
		return valorMaximo;
	}

	public void setValorMaximo(BigDecimal valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	
}
