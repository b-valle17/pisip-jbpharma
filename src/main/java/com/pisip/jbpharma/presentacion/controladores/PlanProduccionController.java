package com.pisip.jbpharma.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IPlanProduccionUseCase;
import com.pisip.jbpharma.dominio.entidades.PlanProduccion;
import com.pisip.jbpharma.presentacion.dto.request.PlanProduccionRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.PlanProduccionResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IPlanProduccionDtoMapper;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/planProduccion")
public class PlanProduccionController {

	private final IPlanProduccionUseCase planProduccionUseCase;
	private final IPlanProduccionDtoMapper mapper;

	public PlanProduccionController(IPlanProduccionUseCase planProduccionUseCase, IPlanProduccionDtoMapper mapper) {
		this.planProduccionUseCase = planProduccionUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlanProduccionResponseDto guardar(@Valid @RequestBody PlanProduccionRequestDto request) {
		return mapper.toResponseDto(planProduccionUseCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping("/{idPlanProduccion}")
	public PlanProduccionResponseDto buscarPorId(@PathVariable Integer idPlan) {
		return mapper.toResponseDto(planProduccionUseCase.buscarPorId(idPlan));
	};

	@GetMapping("/codigo/{codigo}")
	public PlanProduccionResponseDto buscarPorCodigo(@PathVariable String codigo) {
		PlanProduccion plan = planProduccionUseCase.buscarPorCodigo(codigo);
		if (plan == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Plan no encontrado con el código: " + codigo);
		}
		return mapper.toResponseDto(plan);
	}

	@GetMapping("/estado/{estado}")
	public List<PlanProduccionResponseDto> buscarPorEstado(@PathVariable String estado) {
		return planProduccionUseCase.buscarPorEstado(estado).stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping
	public List<PlanProduccionResponseDto> listar() {
		return planProduccionUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer idPlan) {
		planProduccionUseCase.eliminar(idPlan);
		return ResponseEntity.noContent().build();
	}

}
