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

import com.pisip.jbpharma.aplicacion.casouso.entrada.iParametroValidacionUseCase;
import com.pisip.jbpharma.presentacion.dto.request.ParametroValidacionRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.ParametroValidacionResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iParametroValidacionDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/parametroValidacion")
public class ParametroValidacionController {
	
	private final iParametroValidacionUseCase parametroValidacionUseCase;
	private final iParametroValidacionDtoMapper mapper;
	
	public ParametroValidacionController(iParametroValidacionUseCase parametroValidacionUseCase,
			iParametroValidacionDtoMapper mapper) {

		this.parametroValidacionUseCase = parametroValidacionUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ParametroValidacionResponseDTO guardar(@Valid @RequestBody ParametroValidacionRequestDTO request) {
		return mapper.toResponseDto(parametroValidacionUseCase.guardar(mapper.toDomain(request)));
	}
	
	@GetMapping
	public List<ParametroValidacionResponseDTO> listarTodos(){
		return parametroValidacionUseCase.listarTodos().stream().map(mapper :: toResponseDto).toList();
		
	}
	
	@DeleteMapping("/{idParametroValidacion}")
	public ResponseEntity<Void> eliminar(@PathVariable int idParametroValidacion){
		parametroValidacionUseCase.eliminar(idParametroValidacion);
		return ResponseEntity.noContent().build();
	}

}
