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

import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.presentacion.dto.request.ValidacionSemaforicaRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.ValidacionSemaforicaResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iValidacionSemaforicaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/validacionSemaforica")
public class ValidacionSemaforicaController {
	
	private final iValidacionSemaforicaUseCase validacionSemaforicaUseCase;
	private final iValidacionSemaforicaDtoMapper mapper;
	
	public ValidacionSemaforicaController(iValidacionSemaforicaUseCase validacionSemaforicaUseCase,
			iValidacionSemaforicaDtoMapper mapper) {
		
		this.validacionSemaforicaUseCase = validacionSemaforicaUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ValidacionSemaforicaResponseDTO guardar(@Valid @RequestBody ValidacionSemaforicaRequestDTO request) {
		return mapper.toResponseDto(validacionSemaforicaUseCase.guardar(mapper.toDomain(request)));
	}
	
	@GetMapping
	public List<ValidacionSemaforicaResponseDTO> listarTodos(){
		return validacionSemaforicaUseCase.listarTodos().stream().map(mapper :: toResponseDto).toList();
		
	}
	
	@DeleteMapping("/{idValidacionSemaforica}")
	public ResponseEntity<Void> eliminar(@PathVariable int idValidacionSemaforica){
		validacionSemaforicaUseCase.eliminar(idValidacionSemaforica);
		return ResponseEntity.noContent().build();
	}

}
