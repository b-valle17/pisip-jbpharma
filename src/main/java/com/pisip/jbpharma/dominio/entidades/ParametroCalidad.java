package com.pisip.jbpharma.dominio.entidades;

import java.math.BigDecimal;
import java.util.Date;

public class ParametroCalidad {

	 private Integer idParametro;
	 private String nombreParametro;
	 private BigDecimal limiteMinimo;
	 private BigDecimal limiteMaximo;
	 private String unidadMedida;
	 private Date fechaConfiguracion;
	 private Integer idProducto;
	 
	 public ParametroCalidad() {
		super();
	}

	 public ParametroCalidad(int idParametro, String nombreParametro, BigDecimal limiteMinimo, BigDecimal limiteMaximo,
			String unidadMedida, Date fechaConfiguracion, int idProducto) {
		super();
		this.idParametro = idParametro;
		this.nombreParametro = nombreParametro;
		this.limiteMinimo = limiteMinimo;
		this.limiteMaximo = limiteMaximo;
		this.unidadMedida = unidadMedida;
		this.fechaConfiguracion = fechaConfiguracion;
		this.idProducto = idProducto;
	 }

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

	 public Integer getIdProducto() {
		 return idProducto;
	 }

	 public void setIdProducto(Integer idProducto) {
		 this.idProducto = idProducto;
	 }
	 
}
