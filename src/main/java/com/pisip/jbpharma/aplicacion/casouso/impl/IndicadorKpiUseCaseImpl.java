package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IIndicadorKpiUseCase;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;
import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;
import com.pisip.jbpharma.dominio.repositorio.IIndicadorKpiRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IOrdenProduccionRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.presentacion.dto.response.IndicadorKpiResumenDto;

public class IndicadorKpiUseCaseImpl implements IIndicadorKpiUseCase {

	// Estados considerados "finalizados" para un ensayo de laboratorio.
	// Mientras el ensayo no tenga uno de estos estados, el lote se cuenta como en cuarentena/en ensayo.
	private static final List<String> ESTADOS_ENSAYO_FINALIZADO = List.of("APROBADO", "RECHAZADO", "FINALIZADO");

	// Estado que indica que una orden de produccion ya fue concluida.
	private static final String ESTADO_ORDEN_CONCLUIDA = "CONCLUIDA";

	private final IIndicadorKpiRepositorio repositorio;
	private final IOrdenProduccionRepositorio ordenProduccionRepositorio;
	private final iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio;

	public IndicadorKpiUseCaseImpl(IIndicadorKpiRepositorio repositorio,
			IOrdenProduccionRepositorio ordenProduccionRepositorio,
			iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio) {
		this.repositorio = repositorio;
		this.ordenProduccionRepositorio = ordenProduccionRepositorio;
		this.ensayoLaboratorioRepositorio = ensayoLaboratorioRepositorio;
	}

	@Override
	public IndicadorKpi guardar(IndicadorKpi nuevoIndicador) {
		return repositorio.guardar(nuevoIndicador);
	}

	@Override
	public IndicadorKpi buscarPorId(int idKpi) {
		return repositorio.buscarPorId(idKpi)
				.orElseThrow(() -> new RuntimeException("Indicador KPI no encontrado con id: " + idKpi));
	}

	@Override
	public List<IndicadorKpi> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idKpi) {
		repositorio.eliminar(idKpi);
	}

	@Override
	public IndicadorKpiResumenDto calcularResumen() {
		List<OrdenProduccion> ordenes = ordenProduccionRepositorio.listarTodos();
		List<EnsayoLaboratorio> ensayos = ensayoLaboratorioRepositorio.listarTodos();

		long totalOrdenes = ordenes.size();
		long ordenesConcluidas = ordenes.stream()
				.filter(o -> ESTADO_ORDEN_CONCLUIDA.equalsIgnoreCase(o.getEstado()))
				.count();

		BigDecimal cumplimiento = totalOrdenes == 0
				? BigDecimal.ZERO
				: BigDecimal.valueOf(ordenesConcluidas)
						.multiply(BigDecimal.valueOf(100))
						.divide(BigDecimal.valueOf(totalOrdenes), 2, RoundingMode.HALF_UP);

		long lotesEnCuarentena = ensayos.stream()
				.filter(e -> e.getEstado() == null || !ESTADOS_ENSAYO_FINALIZADO.contains(e.getEstado().toUpperCase()))
				.count();

		Map<String, Long> distribucion = ordenes.stream()
				.collect(Collectors.groupingBy(
						o -> o.getEstado() == null ? "SIN_ESTADO" : o.getEstado(),
						Collectors.counting()));

		IndicadorKpiResumenDto resumen = new IndicadorKpiResumenDto();
		resumen.setCumplimientoPlanMensual(cumplimiento);
		resumen.setTotalLotesProducidos(totalOrdenes);
		resumen.setLotesEnCuarentena(lotesEnCuarentena);
		resumen.setDistribucionPorEstado(distribucion);
		return resumen;
	}
}
