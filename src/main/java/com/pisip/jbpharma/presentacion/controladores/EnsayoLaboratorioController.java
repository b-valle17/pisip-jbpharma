package com.pisip.jbpharma.presentacion.controladores;

import java.util.List;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.presentacion.dto.request.EnsayoLaboratorioRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.EnsayoLaboratorioResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iEnsayoLaboratorioDtoMapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ensayos")
public class EnsayoLaboratorioController {
	private final iEnsayoLaboratorioUseCase useCase;
	private final iEnsayoLaboratorioDtoMapper mapper;

	public EnsayoLaboratorioController(iEnsayoLaboratorioUseCase useCase, iEnsayoLaboratorioDtoMapper mapper) {
		this.useCase = useCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EnsayoLaboratorioResponseDTO guardar(@Valid @RequestBody EnsayoLaboratorioRequestDTO request) {
		return mapper.toResponseDto(useCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping
	public List<EnsayoLaboratorioResponseDTO> listarTodos() {
		return useCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{id}")
	public EnsayoLaboratorioResponseDTO buscarPorId(@PathVariable long id) {
		return mapper.toResponseDto(useCase.buscarPorId(id));
	}

	@PutMapping("/{id}")
	public EnsayoLaboratorioResponseDTO actualizar(@PathVariable long id,
			@Valid @RequestBody EnsayoLaboratorioRequestDTO request) {
		return mapper.toResponseDto(useCase.actualizar(id, mapper.toDomain(request)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable long id) {
		useCase.eliminar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscar")
	public List<EnsayoLaboratorioResponseDTO> buscar(@RequestParam String texto) {
		return useCase.buscar(texto).stream().map(mapper::toResponseDto).toList();
	}
}
