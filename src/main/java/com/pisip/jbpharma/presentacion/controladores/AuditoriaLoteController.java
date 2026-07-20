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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IAuditoriaLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.AuditoriaLote;
import com.pisip.jbpharma.presentacion.dto.request.AuditoriaLoteRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.AuditoriaLoteResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IAuditoriaLoteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auditoria-lote")
public class AuditoriaLoteController {

	private final IAuditoriaLoteUseCase auditoriaLoteUseCase;
	private final IAuditoriaLoteDtoMapper mapper;

	public AuditoriaLoteController(IAuditoriaLoteUseCase auditoriaLoteUseCase, IAuditoriaLoteDtoMapper mapper) {
		this.auditoriaLoteUseCase = auditoriaLoteUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AuditoriaLoteResponseDto guardar(@Valid @RequestBody AuditoriaLoteRequestDto request) {
		AuditoriaLote auditoria = mapper.toDomain(request);
		return mapper.toResponseDto(auditoriaLoteUseCase.guardar(auditoria));
	}

	@GetMapping
	public List<AuditoriaLoteResponseDto> listarTodo() {
		return auditoriaLoteUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idAuditoria}")
	public AuditoriaLoteResponseDto buscarPorId(@PathVariable int idAuditoria) {
		return mapper.toResponseDto(auditoriaLoteUseCase.buscarPorId(idAuditoria));
	}

	@DeleteMapping("/{idAuditoria}")
	public ResponseEntity<Void> eliminar(@PathVariable int idAuditoria) {
		auditoriaLoteUseCase.eliminar(idAuditoria);
		return ResponseEntity.noContent().build();
	}
}
