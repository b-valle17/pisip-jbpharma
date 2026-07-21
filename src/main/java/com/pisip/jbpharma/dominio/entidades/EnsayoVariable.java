package com.pisip.jbpharma.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EnsayoVariable {

	private Long idVariable;
	private Long idEnsayo;
	private String nombreVariable;
	private BigDecimal valorObtenido;
	private String unidadMedida;
	private LocalDateTime creadoEn;
	public EnsayoVariable() {
		super();
	}
	public EnsayoVariable(Long idVariable, Long idEnsayo, String nombreVariable, BigDecimal valorObtenido,
			String unidadMedida, LocalDateTime creadoEn) {
		super();
		this.idVariable = idVariable;
		this.idEnsayo = idEnsayo;
		this.nombreVariable = nombreVariable;
		this.valorObtenido = valorObtenido;
		this.unidadMedida = unidadMedida;
		this.creadoEn = creadoEn;
	}
	public Long getIdVariable() {
		return idVariable;
	}
	public void setIdVariable(Long idVariable) {
		this.idVariable = idVariable;
	}
	public Long getIdEnsayo() {
		return idEnsayo;
	}
	public void setIdEnsayo(Long idEnsayo) {
		this.idEnsayo = idEnsayo;
	}
	public String getNombreVariable() {
		return nombreVariable;
	}
	public void setNombreVariable(String nombreVariable) {
		this.nombreVariable = nombreVariable;
	}
	public BigDecimal getValorObtenido() {
		return valorObtenido;
	}
	public void setValorObtenido(BigDecimal valorObtenido) {
		this.valorObtenido = valorObtenido;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}
	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}
	
	
	
}
