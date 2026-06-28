package com.pisip.jbpharma.presentacion.dto.request;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ParametroCalidadRequestDto {

	@NotBlank
	private int idParametro;
	
	@NotBlank
	private String nombreParametro;

	@NotNull
	private BigDecimal limiteMinimo;

	@NotNull
	private BigDecimal limiteMaximo;

	@NotBlank
	private String unidadMedida;

	private Date fechaConfiguracion;

	public int getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	public String getNombreParametro() {
		return nombreParametro;
	}

	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}

	public BigDecimal getLimiteMinimo() {
		return limiteMinimo;
	}

	public void setLimiteMinimo(BigDecimal limiteMinimo) {
		this.limiteMinimo = limiteMinimo;
	}

	public BigDecimal getLimiteMaximo() {
		return limiteMaximo;
	}

	public void setLimiteMaximo(BigDecimal limiteMaximo) {
		this.limiteMaximo = limiteMaximo;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public Date getFechaConfiguracion() {
		return fechaConfiguracion;
	}

	public void setFechaConfiguracion(Date fechaConfiguracion) {
		this.fechaConfiguracion = fechaConfiguracion;
	}
}