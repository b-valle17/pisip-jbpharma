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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IIndicadorKpiUseCase;
import com.pisip.jbpharma.dominio.entidades.IndicadorKpi;
import com.pisip.jbpharma.presentacion.dto.request.IndicadorKpiRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.IndicadorKpiResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IIndicadorKpiDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/indicador-kpi")
public class IndicadorKpiController {

	private final IIndicadorKpiUseCase indicadorKpiUseCase;
	private final IIndicadorKpiDtoMapper mapper;

	public IndicadorKpiController(IIndicadorKpiUseCase indicadorKpiUseCase, IIndicadorKpiDtoMapper mapper) {
		this.indicadorKpiUseCase = indicadorKpiUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public IndicadorKpiResponseDto guardar(@Valid @RequestBody IndicadorKpiRequestDto request) {
		IndicadorKpi indicador = mapper.toDomain(request);
		return mapper.toResponseDto(indicadorKpiUseCase.guardar(indicador));
	}

	@GetMapping
	public List<IndicadorKpiResponseDto> listarTodo() {
		return indicadorKpiUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idKpi}")
	public IndicadorKpiResponseDto buscarPorId(@PathVariable int idKpi) {
		return mapper.toResponseDto(indicadorKpiUseCase.buscarPorId(idKpi));
	}

	@DeleteMapping("/{idKpi}")
	public ResponseEntity<Void> eliminar(@PathVariable int idKpi) {
		indicadorKpiUseCase.eliminar(idKpi);
		return ResponseEntity.noContent().build();
	}
}
