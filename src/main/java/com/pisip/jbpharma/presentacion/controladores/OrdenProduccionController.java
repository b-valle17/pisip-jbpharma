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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IOrdenProduccionUseCase;
import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;
import com.pisip.jbpharma.presentacion.dto.request.OrdenProduccionRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.OrdenProduccionResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IOrdenProduccionDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ordenProduccion")
public class OrdenProduccionController {
	
	private final IOrdenProduccionUseCase ordenProduccionUseCase;
	private final IOrdenProduccionDtoMapper mapper;
	
	public OrdenProduccionController(IOrdenProduccionUseCase ordenProduccionUseCase, IOrdenProduccionDtoMapper mapper) {
		this.ordenProduccionUseCase = ordenProduccionUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenProduccionResponseDto guardar(@Valid @RequestBody OrdenProduccionRequestDto request) {
		return mapper.toResponseDto(ordenProduccionUseCase.guardar(mapper.toDomain(request)));
	}

	@GetMapping("/{idPlanProduccion}")
	public OrdenProduccionResponseDto buscarPorId(@PathVariable Integer idOrden) {
		return mapper.toResponseDto(ordenProduccionUseCase.buscarPorId(idOrden));
	};

	@GetMapping("/codigo/{codigo}")
	public OrdenProduccionResponseDto buscarPorNumeroDeLote(@PathVariable String numeroLote) {
		OrdenProduccion orden = ordenProduccionUseCase.buscarPorNumeroLote(numeroLote);
		if (orden == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada con el número: " + orden);
		}
		return mapper.toResponseDto(orden);
	}

	@GetMapping("/estado/{estado}")
	public List<OrdenProduccionResponseDto> buscarPorEstado(@PathVariable String estado) {
		return ordenProduccionUseCase.buscarPorEstado(estado).stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping
	public List<OrdenProduccionResponseDto> listar() {
		return ordenProduccionUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer idOrden) {
		ordenProduccionUseCase.eliminar(idOrden);
		return ResponseEntity.noContent().build();
	}

	
	

}
