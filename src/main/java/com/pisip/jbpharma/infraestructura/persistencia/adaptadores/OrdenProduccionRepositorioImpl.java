package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.OrdenProduccion;
import com.pisip.jbpharma.dominio.repositorio.IOrdenProduccionRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.OrdenProduccionEntity;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.PlanProduccionEntity;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ProductoEntity;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.UsuarioEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IOrdenProduccionJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IOrdenProduccionJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IPlanProduccionJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IProductoJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IUsuarioJpaRepositorio;

public class OrdenProduccionRepositorioImpl implements IOrdenProduccionRepositorio {

	private final IOrdenProduccionJpaRepositorio jpaRepositorio;
	private final IPlanProduccionJpaRepositorio planJpaRepositorio;
	private final IProductoJpaRepositorio productoJpaRepositorio;
	private final IUsuarioJpaRepositorio usuarioJpaRepositorio;
	private final IOrdenProduccionJpaMapper entityMapper;

	public OrdenProduccionRepositorioImpl(IOrdenProduccionJpaRepositorio jpaRepositorio,
			IPlanProduccionJpaRepositorio planJpaRepositorio,
			IProductoJpaRepositorio productoJpaRepositorio,
			IUsuarioJpaRepositorio usuarioJpaRepositorio,
			IOrdenProduccionJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.planJpaRepositorio = planJpaRepositorio;
		this.productoJpaRepositorio = productoJpaRepositorio;
		this.usuarioJpaRepositorio = usuarioJpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public OrdenProduccion guardar(OrdenProduccion nuevaOrdenProduccion) {

		OrdenProduccionEntity entidad = entityMapper.toEntity(nuevaOrdenProduccion);

		if (nuevaOrdenProduccion.getIdPlan() != null) {
			PlanProduccionEntity planEntity = planJpaRepositorio.findById(nuevaOrdenProduccion.getIdPlan())
					.orElseThrow(() -> new RuntimeException("Plan de Producción no encontrado con ID: " + nuevaOrdenProduccion.getIdPlan()));
			entidad.setPlanProduccion(planEntity);
		} else {
			throw new IllegalArgumentException("El idPlan es obligatorio para guardar una Orden de Producción.");
		}

		if (nuevaOrdenProduccion.getIdProducto() != null) {
			ProductoEntity productoEntity = productoJpaRepositorio.findById(nuevaOrdenProduccion.getIdProducto())
					.orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + nuevaOrdenProduccion.getIdProducto()));
			entidad.setProducto(productoEntity);
		} else {
			throw new IllegalArgumentException("El idProducto es obligatorio para guardar una Orden de Producción.");
		}

		if (nuevaOrdenProduccion.getIdUsuario() != null) {
			UsuarioEntity usuarioEntity = usuarioJpaRepositorio.findById(nuevaOrdenProduccion.getIdUsuario())
					.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + nuevaOrdenProduccion.getIdUsuario()));
			entidad.setUsuario(usuarioEntity);
		} else {
			throw new IllegalArgumentException("El idUsuario es obligatorio para guardar una Orden de Producción.");
		}

		OrdenProduccionEntity guardado = jpaRepositorio.save(entidad);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<OrdenProduccion> buscarPorId(int idOrden) {
		return jpaRepositorio.findById(idOrden).map(entityMapper::toDomain);
	}

	@Override
	public Optional<OrdenProduccion> buscarPorNumeroLote(String numeroLote) {
		return jpaRepositorio.findByNumeroLote(numeroLote).map(entityMapper::toDomain);
	}

	@Override
	public List<OrdenProduccion> buscarPorEstado(String estado) {
		return jpaRepositorio.findByEstado(estado)
                .stream()
                .map(entityMapper::toDomain)
                .toList();
	}

	@Override
	public List<OrdenProduccion> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idOrdenProduccion) {
		jpaRepositorio.deleteById(idOrdenProduccion);
	}

}