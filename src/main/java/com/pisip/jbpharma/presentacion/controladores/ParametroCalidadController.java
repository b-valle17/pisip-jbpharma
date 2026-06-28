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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IParametroCalidadUseCase;
import com.pisip.jbpharma.dominio.entidades.ParametroCalidad;
import com.pisip.jbpharma.presentacion.dto.request.ParametroCalidadRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.ParametroCalidadResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IParametroCalidadDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/parametros-calidad")
public class ParametroCalidadController {

	private final IParametroCalidadUseCase parametroCalidadUseCase;
	private final IParametroCalidadDtoMapper mapper;

	public ParametroCalidadController(IParametroCalidadUseCase parametroCalidadUseCase,
			IParametroCalidadDtoMapper mapper) {
		this.parametroCalidadUseCase = parametroCalidadUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ParametroCalidadResponseDto guardar(@Valid @RequestBody ParametroCalidadRequestDto request) {
		ParametroCalidad parametroCalidad = mapper.toDomain(request);
		if (parametroCalidad.getFechaConfiguracion() == null) {
			parametroCalidad.setFechaConfiguracion(new java.util.Date());
		}
		return mapper.toResponseDto(parametroCalidadUseCase.guardar(parametroCalidad));
	}

	@GetMapping
	public List<ParametroCalidadResponseDto> listarTodo() {
		return parametroCalidadUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idParametro}")
	public ParametroCalidadResponseDto buscarPorId(@PathVariable int idParametro) {
		return mapper.toResponseDto(parametroCalidadUseCase.buscarPorId(idParametro));
	}

	@PutMapping("/{idParametro}")
	public ResponseEntity<ParametroCalidadResponseDto> actualizar(@PathVariable int idParametro,
			@Valid @RequestBody ParametroCalidadRequestDto request) {
		ParametroCalidad parametroCalidad = mapper.toDomain(request);
		if (parametroCalidad.getFechaConfiguracion() == null) {
			parametroCalidad.setFechaConfiguracion(new java.util.Date());
		}
		ParametroCalidad parametroActualizado = parametroCalidadUseCase.actualizar(idParametro, parametroCalidad);
		return ResponseEntity.ok(mapper.toResponseDto(parametroActualizado));
	}

	@DeleteMapping("/{idParametro}")
	public ResponseEntity<Void> eliminar(@PathVariable int idParametro) {
		parametroCalidadUseCase.eliminar(idParametro);
		return ResponseEntity.noContent().build();
	}
}