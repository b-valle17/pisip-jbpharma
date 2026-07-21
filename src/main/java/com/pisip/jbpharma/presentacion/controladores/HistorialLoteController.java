package com.pisip.jbpharma.presentacion.controladores;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IDictamenLoteUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IHistorialLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.HistorialLote;
import com.pisip.jbpharma.presentacion.dto.request.HistorialLoteRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.HistorialLoteResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IHistorialLoteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/historial-lote")
public class HistorialLoteController {

	private static final Set<String> ESTADOS_FINALES = Set.of("ACEPTADO", "RECHAZADO");

	private final IHistorialLoteUseCase historialLoteUseCase;
	private final IDictamenLoteUseCase dictamenLoteUseCase;
	private final IHistorialLoteDtoMapper mapper;

	public HistorialLoteController(IHistorialLoteUseCase historialLoteUseCase,
			IDictamenLoteUseCase dictamenLoteUseCase, IHistorialLoteDtoMapper mapper) {
		this.historialLoteUseCase = historialLoteUseCase;
		this.dictamenLoteUseCase = dictamenLoteUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HistorialLoteResponseDto guardar(@Valid @RequestBody HistorialLoteRequestDto request) {
		HistorialLote historial = mapper.toDomain(request);
		return enriquecerConEstadoLote(mapper.toResponseDto(historialLoteUseCase.guardar(historial)));
	}

	// Lista el historial completo, agregando el estado final (ACEPTADO/RECHAZADO) de cada lote cuando exista.
	@GetMapping
	public List<HistorialLoteResponseDto> listarTodo() {
		return historialLoteUseCase.listarTodos().stream()
				.map(mapper::toResponseDto)
				.map(this::enriquecerConEstadoLote)
				.toList();
	}

	// Filtra el historial solo por lotes ya aceptados o rechazados (para la ventana de Historial de Lotes).
	// Uso: GET /api/historial-lote/finalizados            -> todos los aceptados y rechazados
	//      GET /api/historial-lote/finalizados?estado=ACEPTADO  -> solo los aceptados
	@GetMapping("/finalizados")
	public List<HistorialLoteResponseDto> listarFinalizados(@RequestParam(required = false) String estado) {
		return listarTodo().stream()
				.filter(dto -> dto.getEstadoLote() != null && ESTADOS_FINALES.contains(dto.getEstadoLote()))
				.filter(dto -> estado == null || estado.equalsIgnoreCase(dto.getEstadoLote()))
				.toList();
	}

	@GetMapping("/{idHistorial}")
	public HistorialLoteResponseDto buscarPorId(@PathVariable int idHistorial) {
		return enriquecerConEstadoLote(mapper.toResponseDto(historialLoteUseCase.buscarPorId(idHistorial)));
	}

	@DeleteMapping("/{idHistorial}")
	public ResponseEntity<Void> eliminar(@PathVariable int idHistorial) {
		historialLoteUseCase.eliminar(idHistorial);
		return ResponseEntity.noContent().build();
	}

	private HistorialLoteResponseDto enriquecerConEstadoLote(HistorialLoteResponseDto dto) {
		dictamenLoteUseCase.buscarPorOrdenProduccion(dto.getIdOrdenProduccion())
				.ifPresent(dictamen -> dto.setEstadoLote(dictamen.getEstado()));
		return dto;
	}
}
