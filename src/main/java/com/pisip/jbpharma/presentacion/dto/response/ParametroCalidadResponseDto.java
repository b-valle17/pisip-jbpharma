package com.pisip.jbpharma.presentacion.dto.response;

import java.math.BigDecimal;
import java.util.Date;

public class ParametroCalidadResponseDto {

	private int idParametro;
	private String nombreParametro;
	private BigDecimal limiteMinimo;
	private BigDecimal limiteMaximo;
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