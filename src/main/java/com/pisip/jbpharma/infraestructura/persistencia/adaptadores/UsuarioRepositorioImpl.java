package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.Usuario;
import com.pisip.jbpharma.dominio.repositorio.IUsuarioRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.UsuarioEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IUsuarioJpaRepositorio;

public class UsuarioRepositorioImpl implements IUsuarioRepositorio {

    private final IUsuarioJpaRepositorio jpaRepositorio;
    private final IUsuarioJpaMapper entityMapper;

    public UsuarioRepositorioImpl(IUsuarioJpaRepositorio jpaRepositorio, IUsuarioJpaMapper entityMapper) {
        this.jpaRepositorio = jpaRepositorio;
        this.entityMapper = entityMapper;
    }

    @Override
    public Usuario guardar(Usuario nuevoUsuario) {
        // 1. Mapeamos de Dominio a Entidad JPA
        UsuarioEntity entity = entityMapper.toEntity(nuevoUsuario);

        // 2. CORRECCIÓN CLAVE: Si el ID es 0 o nulo, asignamos NULL explícitamente en la Entidad
        // Esto le indica a JPA que es una CREACIÓN (INSERT) y no un UPDATE de la fila 0.
        if (entity.getIdUsuario() != null && entity.getIdUsuario() <= 0) {
            entity.setIdUsuario(null);
        }

        // 3. Guardamos la entidad corregida
        UsuarioEntity guardado = jpaRepositorio.save(entity);
        return entityMapper.toDomain(guardado);
    }

    @Override
    public Optional<Usuario> buscarPorId(int idUsuario) {
        return jpaRepositorio.findById(idUsuario).map(entityMapper::toDomain);
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correo) {
        return jpaRepositorio.findByCorreo(correo).map(entityMapper::toDomain);
    }

    @Override
    public Optional<Usuario> autenticar(String correo, String contrasenaHash) {
        return jpaRepositorio.findByCorreoAndContrasenaHash(correo, contrasenaHash).map(entityMapper::toDomain);
    }

    @Override
    public List<Usuario> listarTodos() {
        return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
    }

    @Override
    public void eliminar(int idUsuario) {
        jpaRepositorio.deleteById(idUsuario);
    }
}
