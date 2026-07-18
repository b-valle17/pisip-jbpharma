package com.pisip.jbpharma.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IHistorialLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.HistorialLote;
import com.pisip.jbpharma.presentacion.dto.request.HistorialLoteRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.HistorialLoteResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IHistorialLoteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/historial-lote")
public class HistorialLoteController {

	private final IHistorialLoteUseCase historialLoteUseCase;
	private final IHistorialLoteDtoMapper mapper;

	public HistorialLoteController(IHistorialLoteUseCase historialLoteUseCase, IHistorialLoteDtoMapper mapper) {
		this.historialLoteUseCase = historialLoteUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HistorialLoteResponseDto guardar(@Valid @RequestBody HistorialLoteRequestDto request) {
		HistorialLote historialLote = mapper.toDomain(request);
		return mapper.toResponseDto(historialLoteUseCase.guardar(historialLote));
	}

	@GetMapping
	public List<HistorialLoteResponseDto> listarTodo() {
		return historialLoteUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idHistorial}")
	public HistorialLoteResponseDto buscarPorId(@PathVariable int idHistorial) {
		return mapper.toResponseDto(historialLoteUseCase.buscarPorId(idHistorial));
	}

	@PutMapping("/{idHistorial}")
	public ResponseEntity<HistorialLoteResponseDto> actualizar(
			@PathVariable int idHistorial,
			@Valid @RequestBody HistorialLoteRequestDto request) {
		HistorialLote historialLoteDatos = mapper.toDomain(request);
		HistorialLote historialLoteActualizado = historialLoteUseCase.actualizar(idHistorial, historialLoteDatos);
		return ResponseEntity.ok(mapper.toResponseDto(historialLoteActualizado));
	}

	@DeleteMapping("/{idHistorial}")
	public ResponseEntity<Void> eliminar(@PathVariable int idHistorial) {
		historialLoteUseCase.eliminar(idHistorial);
		return ResponseEntity.noContent().build();
	}
}
