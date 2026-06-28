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

import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoVariableUseCase;
import com.pisip.jbpharma.presentacion.dto.request.EnsayoVariableRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.EnsayoVariableResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iEnsayoVariableDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/ensayoVariable")
public class EnsayoVariableController {
	
	private final iEnsayoVariableUseCase ensayoVariableUseCase;
	private final iEnsayoVariableDtoMapper mapper;
	
	public EnsayoVariableController(iEnsayoVariableUseCase ensayoVariableUseCase, iEnsayoVariableDtoMapper mapper) {
		
		this.ensayoVariableUseCase = ensayoVariableUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EnsayoVariableResponseDTO guardar(@Valid @RequestBody EnsayoVariableRequestDTO request) {
		return mapper.toResponseDto(ensayoVariableUseCase.guardar(mapper.toDomain(request)));
	}
	
	@GetMapping
	public List<EnsayoVariableResponseDTO> listarTodos(){
		return ensayoVariableUseCase.listarTodos().stream().map(mapper :: toResponseDto).toList();
		
	}
	
	@DeleteMapping("/{idEnsayoVariable}")
	public ResponseEntity<Void> eliminar(@PathVariable int idEnsayoVariable){
		ensayoVariableUseCase.eliminar(idEnsayoVariable);
		return ResponseEntity.noContent().build();
	}

}
