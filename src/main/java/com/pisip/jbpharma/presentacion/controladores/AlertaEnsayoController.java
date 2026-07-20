package com.pisip.jbpharma.presentacion.controladores;

import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iAlertaEnsayoUseCase;
import com.pisip.jbpharma.presentacion.dto.request.AlertaEnsayoRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.AlertaEnsayoResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iAlertaEnsayoDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alertas")
public class AlertaEnsayoController {
	private final iAlertaEnsayoUseCase useCase;
	private final iAlertaEnsayoDtoMapper mapper;

	public AlertaEnsayoController(iAlertaEnsayoUseCase useCase, iAlertaEnsayoDtoMapper mapper) {
		this.useCase = useCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AlertaEnsayoResponseDTO guardar(@Valid @RequestBody AlertaEnsayoRequestDTO request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<AlertaEnsayoResponseDTO> listarTodos() {
		return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public AlertaEnsayoResponseDTO buscarPorId(@PathVariable long id) {
		return mapper.toResponseDto(useCase.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public AlertaEnsayoResponseDTO actualizar(@PathVariable long id,
			@Valid @RequestBody AlertaEnsayoRequestDTO request) {
		return mapper.toResponseDto(useCase.actualizar(id, mapper.toDomain(request)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable long id) {
		useCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
