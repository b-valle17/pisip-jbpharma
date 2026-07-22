package com.pisip.jbpharma.presentacion.dto.response;

import java.math.BigDecimal;
import java.util.Map;

public class IndicadorKpiResumenDto {

	/** Porcentaje de ordenes concluidas sobre el total planificado (0-100). */
	private BigDecimal cumplimientoPlanMensual;

	/** Cantidad total de ordenes de produccion registradas en el periodo actual. */
	private long totalLotesProducidos;

	/** Cantidad de lotes cuyo ensayo de laboratorio aun no ha finalizado (en cuarentena/en ensayo). */
	private long lotesEnCuarentena;

	/** Cantidad de ordenes de produccion agrupadas por su estado (ej: CONCLUIDA, EN_PROCESO, etc). */
	private Map<String, Long> distribucionPorEstado;

	public BigDecimal getCumplimientoPlanMensual() {
		return cumplimientoPlanMensual;
	}

	public void setCumplimientoPlanMensual(BigDecimal cumplimientoPlanMensual) {
		this.cumplimientoPlanMensual = cumplimientoPlanMensual;
	}

	public long getTotalLotesProducidos() {
		return totalLotesProducidos;
	}

	public void setTotalLotesProducidos(long totalLotesProducidos) {
		this.totalLotesProducidos = totalLotesProducidos;
	}

	public long getLotesEnCuarentena() {
		return lotesEnCuarentena;
	}

	public void setLotesEnCuarentena(long lotesEnCuarentena) {
		this.lotesEnCuarentena = lotesEnCuarentena;
	}

	public Map<String, Long> getDistribucionPorEstado() {
		return distribucionPorEstado;
	}

	public void setDistribucionPorEstado(Map<String, Long> distribucionPorEstado) {
		this.distribucionPorEstado = distribucionPorEstado;
	}
}
