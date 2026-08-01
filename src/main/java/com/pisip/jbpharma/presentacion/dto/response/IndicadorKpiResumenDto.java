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

	/** Cantidad de dictamenes de lote en estado ACEPTADO. */
	private long dictamenesAceptados;

	/** Cantidad de dictamenes de lote en estado RECHAZADO. */
	private long dictamenesRechazados;

	/** Cantidad de dictamenes en estado PENDIENTE, sin resolver todavia. */
	private long dictamenesPendientes;

	/** Porcentaje de dictamenes resueltos (ACEPTADO+RECHAZADO) que fueron aceptados (0-100). */
	private BigDecimal tasaAprobacionDictamenes;

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

	public long getDictamenesAceptados() {
		return dictamenesAceptados;
	}

	public void setDictamenesAceptados(long dictamenesAceptados) {
		this.dictamenesAceptados = dictamenesAceptados;
	}

	public long getDictamenesRechazados() {
		return dictamenesRechazados;
	}

	public void setDictamenesRechazados(long dictamenesRechazados) {
		this.dictamenesRechazados = dictamenesRechazados;
	}

	public long getDictamenesPendientes() {
		return dictamenesPendientes;
	}

	public void setDictamenesPendientes(long dictamenesPendientes) {
		this.dictamenesPendientes = dictamenesPendientes;
	}

	public BigDecimal getTasaAprobacionDictamenes() {
		return tasaAprobacionDictamenes;
	}

	public void setTasaAprobacionDictamenes(BigDecimal tasaAprobacionDictamenes) {
		this.tasaAprobacionDictamenes = tasaAprobacionDictamenes;
	}
}
