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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IUsuarioUseCase;
import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.presentacion.dto.request.UsuarioRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.UsuarioResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IUsuarioDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	private final IUsuarioUseCase usuarioUseCase;
	private final IUsuarioDtoMapper mapper;

	public UsuarioController(IUsuarioUseCase usuarioUseCase, IUsuarioDtoMapper mapper) {
		this.usuarioUseCase = usuarioUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UsuarioResponseDto guardar(@Valid @RequestBody UsuarioRequestDto request) {
		Usuario usuario = mapper.toDomain(request);
		usuario.setEstadoUsuario(Boolean.TRUE.equals(request.isEstadoUsuario()));
		if (usuario.getFechaCreacion() == null) {
			usuario.setFechaCreacion(new java.util.Date());
		}
		return mapper.toResponseDto(usuarioUseCase.guardar(usuario));
	}

	@PostMapping("/login")
	public ResponseEntity<UsuarioResponseDto> login(
			@Valid @RequestBody com.pisip.jbpharma.presentacion.dto.request.LoginRequestDto request) {
		Usuario usuario = usuarioUseCase.autenticar(request.getCorreo(), request.getContrasenaHash());
		return ResponseEntity.ok(mapper.toResponseDto(usuario));
	}

	@GetMapping
	public List<UsuarioResponseDto> listarTodo() {
		return usuarioUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idUsuario}")
	public UsuarioResponseDto buscarPorId(@PathVariable int idUsuario) {
		return mapper.toResponseDto(usuarioUseCase.buscarPorId(idUsuario));
	}

	@DeleteMapping("/{idUsuario}")
	public ResponseEntity<Void> eliminar(@PathVariable int idUsuario) {
		usuarioUseCase.eliminar(idUsuario);
		return ResponseEntity.noContent().build();
	}
}
