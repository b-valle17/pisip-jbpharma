package com.pisip.jbpharma.presentacion.controladores;

import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoVariableUseCase;
import com.pisip.jbpharma.presentacion.dto.request.EnsayoVariableRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.EnsayoVariableResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iEnsayoVariableDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/variables")
public class EnsayoVariableController {
	private final iEnsayoVariableUseCase useCase;
	private final iEnsayoVariableDtoMapper mapper;

	public EnsayoVariableController(iEnsayoVariableUseCase useCase, iEnsayoVariableDtoMapper mapper) {
		this.useCase = useCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EnsayoVariableResponseDTO guardar(@Valid @RequestBody EnsayoVariableRequestDTO request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<EnsayoVariableResponseDTO> listarTodos() {
		return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public EnsayoVariableResponseDTO buscarPorId(@PathVariable long id) {
		return mapper.toResponseDto(useCase.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public EnsayoVariableResponseDTO actualizar(@PathVariable long id,
			@Valid @RequestBody EnsayoVariableRequestDTO request) {
		return mapper.toResponseDto(useCase.actualizar(id, mapper.toDomain(request)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable long id) {
		useCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}
}
