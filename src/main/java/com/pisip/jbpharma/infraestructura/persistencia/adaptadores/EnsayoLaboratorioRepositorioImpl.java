package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoLaboratorioEntity;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.OrdenProduccionEntity;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.ProductoEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoLaboratoriojpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IOrdenProduccionJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IProductoJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoLaboratoriojpaRepositorio;

public class EnsayoLaboratorioRepositorioImpl implements iEnsayoLaboratorioRepositorio {

    private final iEnsayoLaboratoriojpaRepositorio jpaRepositorio;
    private final IOrdenProduccionJpaRepositorio ordenRepositorio;
    private final IProductoJpaRepositorio productoRepositorio;
    private final iEnsayoLaboratoriojpaMapper entityMapper;

    public EnsayoLaboratorioRepositorioImpl(
            iEnsayoLaboratoriojpaRepositorio jpaRepositorio,
            IOrdenProduccionJpaRepositorio ordenRepositorio,
            IProductoJpaRepositorio productoRepositorio,
            iEnsayoLaboratoriojpaMapper entityMapper) {
        this.jpaRepositorio = jpaRepositorio;
        this.ordenRepositorio = ordenRepositorio;
        this.productoRepositorio = productoRepositorio;
        this.entityMapper = entityMapper;
    }

    @Override
    public EnsayoLaboratorio guardar(EnsayoLaboratorio ensayo) {
        if (ensayo.getIdOrden() == null) {
            throw new IllegalArgumentException("La orden de producción es obligatoria.");
        }
        if (ensayo.getIdProducto() == null) {
            throw new IllegalArgumentException("El producto es obligatorio.");
        }

        OrdenProduccionEntity orden = ordenRepositorio.findById(ensayo.getIdOrden())
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe la orden de producción con ID " + ensayo.getIdOrden() + "."));
        ProductoEntity producto = productoRepositorio.findById(ensayo.getIdProducto())
                .orElseThrow(() -> new IllegalArgumentException(
                        "No existe el producto con ID " + ensayo.getIdProducto() + "."));

        if (orden.getProducto() != null
                && orden.getProducto().getIdProducto() != null
                && !orden.getProducto().getIdProducto().equals(producto.getIdProducto())) {
            throw new IllegalArgumentException(
                    "El producto seleccionado no corresponde a la orden de producción elegida.");
        }

        EnsayoLaboratorioEntity entidad = entityMapper.toEntity(ensayo);
        entidad.setOrdenProduccion(orden);
        entidad.setProducto(producto);

        EnsayoLaboratorioEntity guardado = jpaRepositorio.save(entidad);
        return entityMapper.toDominio(guardado);
    }

    @Override
    public Optional<EnsayoLaboratorio> buscarPorId(long id) {
        return jpaRepositorio.findById(id).map(entityMapper::toDominio);
    }

    @Override
    public List<EnsayoLaboratorio> listarTodos() {
        return jpaRepositorio.findAll().stream().map(entityMapper::toDominio).toList();
    }

    @Override
    public void eliminar(long id) {
        jpaRepositorio.deleteById(id);
    }

    @Override
    public Optional<EnsayoLaboratorio> buscarPorIdOrden(int idOrden) {
        return jpaRepositorio.findByOrdenProduccion_IdOrdenOrderByFechaEnsayoDesc(idOrden)
                .stream().findFirst().map(entityMapper::toDominio);
    }
}
