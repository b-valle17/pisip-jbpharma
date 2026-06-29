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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IInformeAuditoriaUseCase;
import com.pisip.jbpharma.dominio.entidades.InformeAuditoria;
import com.pisip.jbpharma.presentacion.dto.request.InformeAuditoriaRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.InformeAuditoriaResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IInformeAuditoriaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/informe-auditoria")
public class InformeAuditoriaController {

	private final IInformeAuditoriaUseCase informeAuditoriaUseCase;
	private final IInformeAuditoriaDtoMapper mapper;

	public InformeAuditoriaController(IInformeAuditoriaUseCase informeAuditoriaUseCase,
			IInformeAuditoriaDtoMapper mapper) {
		this.informeAuditoriaUseCase = informeAuditoriaUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public InformeAuditoriaResponseDto guardar(@Valid @RequestBody InformeAuditoriaRequestDto request) {
		InformeAuditoria informe = mapper.toDomain(request);
		return mapper.toResponseDto(informeAuditoriaUseCase.guardar(informe));
	}

	@GetMapping
	public List<InformeAuditoriaResponseDto> listarTodo() {
		return informeAuditoriaUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idInforme}")
	public InformeAuditoriaResponseDto buscarPorId(@PathVariable int idInforme) {
		return mapper.toResponseDto(informeAuditoriaUseCase.buscarPorId(idInforme));
	}

	@DeleteMapping("/{idInforme}")
	public ResponseEntity<Void> eliminar(@PathVariable int idInforme) {
		informeAuditoriaUseCase.eliminar(idInforme);
		return ResponseEntity.noContent().build();
	}
}
