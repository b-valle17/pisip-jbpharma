package com.pisip.jbpharma.presentacion.controladores;

import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.presentacion.dto.request.ValidacionSemaforicaRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.ValidacionSemaforicaResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iValidacionSemaforicaDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/validaciones")
public class ValidacionSemaforicaController {
	private final iValidacionSemaforicaUseCase useCase;
	private final iValidacionSemaforicaDtoMapper mapper;

	public ValidacionSemaforicaController(iValidacionSemaforicaUseCase useCase, iValidacionSemaforicaDtoMapper mapper) {
		this.useCase = useCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ValidacionSemaforicaResponseDTO guardar(@Valid @RequestBody ValidacionSemaforicaRequestDTO request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<ValidacionSemaforicaResponseDTO> listarTodos() {
		return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public ValidacionSemaforicaResponseDTO buscarPorId(@PathVariable long id) {
		return mapper.toResponseDto(useCase.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public ValidacionSemaforicaResponseDTO actualizar(@PathVariable long id,
			@Valid @RequestBody ValidacionSemaforicaRequestDTO request) {
		return mapper.toResponseDto(useCase.actualizar(id, mapper.toDomain(request)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable long id) {
		useCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
