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

import com.pisip.jbpharma.aplicacion.casouso.entrada.iUsuarioUseCase;
import com.pisip.jbpharma.presentacion.dto.request.UsuarioRequestDTO;
import com.pisip.jbpharma.presentacion.dto.response.UsuarioResponseDTO;
import com.pisip.jbpharma.presentacion.mapeadores.iUsuarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {
	
	private final iUsuarioUseCase usuarioUseCase;
	private final iUsuarioDtoMapper mapper;

	public UsuarioController(iUsuarioUseCase usuarioUseCase, iUsuarioDtoMapper mapper) {
		
		this.usuarioUseCase = usuarioUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDTO guardar(@Valid @RequestBody UsuarioRequestDTO request) {
		return mapper.toResponseDto(usuarioUseCase.guardar(mapper.toDomain(request)));
	}
	
	@GetMapping
	public List<UsuarioResponseDTO> listarTodos(){
		return usuarioUseCase.listarTodos().stream().map(mapper :: toResponseDto).toList();
		
	}
	
	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Void> eliminar(@PathVariable int idUsuario){
		usuarioUseCase.eliminar(idUsuario);
		return ResponseEntity.noContent().build();
	}

}
