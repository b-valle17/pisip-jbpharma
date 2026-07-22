package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.time.LocalDateTime;
import java.util.List;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;
import com.pisip.jbpharma.dominio.repositorio.iValidacionSemaforicaRepositorio;

public class ValidacionSemaforicaUseCaseImpl implements iValidacionSemaforicaUseCase {
    private final iValidacionSemaforicaRepositorio repositorio;
    public ValidacionSemaforicaUseCaseImpl(iValidacionSemaforicaRepositorio repositorio) { this.repositorio = repositorio; }
    @Override public ValidacionSemaforica guardar(ValidacionSemaforica nuevo) {
        nuevo.setIdValidacion(null);
        if (nuevo.getFechaValidacion() == null) nuevo.setFechaValidacion(LocalDateTime.now());
        return repositorio.guardar(nuevo);
    }
    @Override public ValidacionSemaforica buscarPorId(long id) { return repositorio.buscarPorId(id).orElseThrow(() -> new RuntimeException("Validación no encontrada")); }
    @Override public List<ValidacionSemaforica> listarTodos() { return repositorio.listarTodos(); }
    @Override public ValidacionSemaforica actualizar(long id, ValidacionSemaforica datos) {
        ValidacionSemaforica actual = buscarPorId(id);
        datos.setIdValidacion(id);
        if (datos.getFechaValidacion() == null) datos.setFechaValidacion(actual.getFechaValidacion());
        return repositorio.guardar(datos);
    }
    @Override public void eliminar(long id) { buscarPorId(id); repositorio.eliminar(id); }
}
