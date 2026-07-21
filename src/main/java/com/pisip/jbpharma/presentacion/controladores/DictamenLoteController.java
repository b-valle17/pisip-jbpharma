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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IDictamenLoteUseCase;
import com.pisip.jbpharma.dominio.entidades.DictamenLote;
import com.pisip.jbpharma.presentacion.dto.request.DictamenLoteRequestDto;
import com.pisip.jbpharma.presentacion.dto.request.DictamenRechazoRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.DictamenLoteResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IDictamenLoteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dictamen-lote")
public class DictamenLoteController {

	private final IDictamenLoteUseCase dictamenLoteUseCase;
	private final IDictamenLoteDtoMapper mapper;

	public DictamenLoteController(IDictamenLoteUseCase dictamenLoteUseCase, IDictamenLoteDtoMapper mapper) {
		this.dictamenLoteUseCase = dictamenLoteUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DictamenLoteResponseDto guardar(@Valid @RequestBody DictamenLoteRequestDto request) {
		DictamenLote dictamen = mapper.toDomain(request);
		return mapper.toResponseDto(dictamenLoteUseCase.guardar(dictamen));
	}

	@GetMapping
	public List<DictamenLoteResponseDto> listarTodo() {
		return dictamenLoteUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idDictamen}")
	public DictamenLoteResponseDto buscarPorId(@PathVariable int idDictamen) {
		return mapper.toResponseDto(dictamenLoteUseCase.buscarPorId(idDictamen));
	}

	// Trae el dictamen junto con los datos del ensayo de laboratorio del mismo lote (para la ventana de revision).
	@GetMapping("/{idDictamen}/ensayo")
	public DictamenLoteResponseDto buscarConEnsayo(@PathVariable int idDictamen) {
		return dictamenLoteUseCase.buscarConEnsayo(idDictamen);
	}

	@PutMapping("/{idDictamen}/aceptar")
	public DictamenLoteResponseDto aceptar(@PathVariable int idDictamen) {
		return mapper.toResponseDto(dictamenLoteUseCase.aceptar(idDictamen));
	}

	@PutMapping("/{idDictamen}/rechazar")
	public DictamenLoteResponseDto rechazar(@PathVariable int idDictamen,
			@Valid @RequestBody DictamenRechazoRequestDto request) {
		return mapper.toResponseDto(dictamenLoteUseCase.rechazar(idDictamen, request.getMotivo()));
	}

	@DeleteMapping("/{idDictamen}")
	public ResponseEntity<Void> eliminar(@PathVariable int idDictamen) {
		dictamenLoteUseCase.eliminar(idDictamen);
		return ResponseEntity.noContent().build();
	}
}
