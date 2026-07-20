package com.pisip.jbpharma.presentacion.dto.response;

import java.sql.Date;

public class AuditoriaLoteResponseDto {

	private int idAuditoria;
	private int idOrdenProduccion;
	private int idUsuarioAuditor;
	private Date fechaAuditoria;
	private String resultado;
	private String observaciones;

	public int getIdAuditoria() { return idAuditoria; }
	public void setIdAuditoria(int idAuditoria) { this.idAuditoria = idAuditoria; }

	public int getIdOrdenProduccion() { return idOrdenProduccion; }
	public void setIdOrdenProduccion(int idOrdenProduccion) { this.idOrdenProduccion = idOrdenProduccion; }

	public int getIdUsuarioAuditor() { return idUsuarioAuditor; }
	public void setIdUsuarioAuditor(int idUsuarioAuditor) { this.idUsuarioAuditor = idUsuarioAuditor; }

	public Date getFechaAuditoria() { return fechaAuditoria; }
	public void setFechaAuditoria(Date fechaAuditoria) { this.fechaAuditoria = fechaAuditoria; }

	public String getResultado() { return resultado; }
	public void setResultado(String resultado) { this.resultado = resultado; }

	public String getObservaciones() { return observaciones; }
	public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}
