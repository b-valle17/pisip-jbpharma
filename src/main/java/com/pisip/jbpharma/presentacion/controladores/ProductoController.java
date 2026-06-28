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

import com.pisip.jbpharma.aplicacion.casouso.entrada.IProductoUseCase;
import com.pisip.jbpharma.dominio.entidades.Producto;
import com.pisip.jbpharma.presentacion.dto.request.ProductoRequestDto;
import com.pisip.jbpharma.presentacion.dto.response.ProductoResponseDto;
import com.pisip.jbpharma.presentacion.mapeadores.IProductoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	private final IProductoUseCase productoUseCase;
	private final IProductoDtoMapper mapper;

	public ProductoController(IProductoUseCase productoUseCase, IProductoDtoMapper mapper) {
		this.productoUseCase = productoUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoResponseDto guardar(@Valid @RequestBody ProductoRequestDto request) {
		Producto producto = mapper.toDomain(request);
		return mapper.toResponseDto(productoUseCase.guardar(producto));
	}

	@GetMapping
	public List<ProductoResponseDto> listarTodo() {
		return productoUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idProducto}")
	public ProductoResponseDto buscarPorId(@PathVariable int idProducto) {
		return mapper.toResponseDto(productoUseCase.buscarPorId(idProducto));
	}
	
	@PutMapping("/{idProducto}")
	public ResponseEntity<ProductoResponseDto> actualizar(
			@PathVariable int idProducto, 
			@Valid @RequestBody ProductoRequestDto request) {
		Producto productoDatos = mapper.toDomain(request);
		Producto productoActualizado = productoUseCase.actualizar(idProducto, productoDatos);
		return ResponseEntity.ok(mapper.toResponseDto(productoActualizado));
	}

	@DeleteMapping("/{idProducto}")
	public ResponseEntity<Void> eliminar(@PathVariable int idProducto) {
		productoUseCase.eliminar(idProducto);
		return ResponseEntity.noContent().build();
	}
}