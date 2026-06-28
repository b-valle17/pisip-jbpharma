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

import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.presentacion.dto.request.EnsayoLaboratorioRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.EnsayoLaboratorioResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iEnsayoLaboratorioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/ensayoLaboratorio")
public class EnsayoLaboratorioController {

	private final iEnsayoLaboratorioUseCase ensayoLaboratorioUseCase;
	private final iEnsayoLaboratorioDtoMapper mapper;
	
	public EnsayoLaboratorioController(iEnsayoLaboratorioUseCase ensayoLaboratorioUseCase,
			iEnsayoLaboratorioDtoMapper mapper) {
		super();
		this.ensayoLaboratorioUseCase = ensayoLaboratorioUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EnsayoLaboratorioResponseDTO guardar(@Valid @RequestBody EnsayoLaboratorioRequestDTO request) {
		return mapper.toResponseDto(ensayoLaboratorioUseCase.guardar(mapper.toDomain(request)));
	}
	
	@GetMapping
	public List<EnsayoLaboratorioResponseDTO> listarTodos(){
		return ensayoLaboratorioUseCase.listarTodos().stream().map(mapper :: toResponseDto).toList();
		
	}
	
	@DeleteMapping("/{idEnsayoLaboratorio}")
	public ResponseEntity<Void> eliminar(@PathVariable int idEnsayoLaboratorio){
		ensayoLaboratorioUseCase.eliminar(idEnsayoLaboratorio);
		return ResponseEntity.noContent().build();
	}

	
}
