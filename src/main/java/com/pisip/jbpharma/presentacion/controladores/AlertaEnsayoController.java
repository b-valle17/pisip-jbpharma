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

import com.pisip.jbpharma.aplicacion.casouso.entrada.iAlertaEnsayoUseCase;
import com.pisip.jbpharma.presentacion.dto.request.AlertaEnsayoRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.AlertaEnsayoResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iAlertaEnsayoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/alertaEnsayo")
public class AlertaEnsayoController {

	private final iAlertaEnsayoUseCase alertaEnsayoUseCase;
	private final iAlertaEnsayoDtoMapper mapper;
	
	public AlertaEnsayoController(iAlertaEnsayoUseCase alertaEnsayoUseCase, iAlertaEnsayoDtoMapper mapper) {
		
		this.alertaEnsayoUseCase = alertaEnsayoUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AlertaEnsayoResponseDTO guardar(@Valid @RequestBody AlertaEnsayoRequestDTO request) {
		return mapper.toResponseDto(alertaEnsayoUseCase.guardar(mapper.toDomain(request)));
	}
	
	@GetMapping
	public List<AlertaEnsayoResponseDTO> listarTodos(){
		return alertaEnsayoUseCase.listarTodos().stream().map(mapper :: toResponseDto).toList();
		
	}
	
	@DeleteMapping("/{idAlertaEnsayo}")
	public ResponseEntity<Void> eliminar(@PathVariable int idAlertaEnsayo){
		alertaEnsayoUseCase.eliminar(idAlertaEnsayo);
		return ResponseEntity.noContent().build();
	}
}
