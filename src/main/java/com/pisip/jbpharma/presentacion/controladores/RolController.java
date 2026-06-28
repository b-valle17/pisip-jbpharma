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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IRolUseCase;
import com.pisip.jbpharma.dominio.entidades.Rol;
import com.pisip.jbpharma.presentacion.dto.request.RolRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.RolResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IRolDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/roles")
public class RolController {

	private final IRolUseCase rolUseCase;
	private final IRolDtoMapper mapper;

	public RolController(IRolUseCase rolUseCase, IRolDtoMapper mapper) {
		this.rolUseCase = rolUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public RolResponseDto guardar(@Valid @RequestBody RolRequestDto request) {
		Rol rol = mapper.toDomain(request);
		return mapper.toResponseDto(rolUseCase.guardar(rol));
	}

	@GetMapping
	public List<RolResponseDto> listarTodo() {
		return rolUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idRol}")
	public RolResponseDto buscarPorId(@PathVariable int idRol) {
		return mapper.toResponseDto(rolUseCase.buscarPorId(idRol));
	}

	@DeleteMapping("/{idRol}")
	public ResponseEntity<Void> eliminar(@PathVariable int idRol) {
		rolUseCase.eliminar(idRol);
		return ResponseEntity.noContent().build();
	}
}