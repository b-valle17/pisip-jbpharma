package com.pisip.jbpharma.aplicacion.casouso.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.entidades.EnsayoVariable;
import com.pisip.jbpharma.dominio.entidades.ParametroCalidad;
import com.pisip.jbpharma.dominio.entidades.ValidacionSemaforica;
import com.pisip.jbpharma.dominio.repositorio.IParametroCalidadRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoVariableRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iValidacionSemaforicaRepositorio;

public class ValidacionSemaforicaUseCaseImpl implements iValidacionSemaforicaUseCase {

    private static final BigDecimal PORCENTAJE_ADVERTENCIA = new BigDecimal("0.10");

    private final iValidacionSemaforicaRepositorio repositorio;
    private final iEnsayoVariableRepositorio variableRepositorio;
    private final IParametroCalidadRepositorio parametroRepositorio;
    private final iEnsayoLaboratorioRepositorio ensayoRepositorio;

    public ValidacionSemaforicaUseCaseImpl(
            iValidacionSemaforicaRepositorio repositorio,
            iEnsayoVariableRepositorio variableRepositorio,
            IParametroCalidadRepositorio parametroRepositorio,
            iEnsayoLaboratorioRepositorio ensayoRepositorio) {
        this.repositorio = repositorio;
        this.variableRepositorio = variableRepositorio;
        this.parametroRepositorio = parametroRepositorio;
        this.ensayoRepositorio = ensayoRepositorio;
    }

    @Override
    public ValidacionSemaforica guardar(ValidacionSemaforica nuevo) {
        nuevo.setIdValidacion(null);
        evaluar(nuevo);
        return repositorio.guardar(nuevo);
    }

    @Override
    public ValidacionSemaforica buscarPorId(long id) {
        return repositorio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Validación no encontrada: " + id));
    }

    @Override
    public List<ValidacionSemaforica> listarTodos() {
        return repositorio.listarTodos();
    }

    @Override
    public ValidacionSemaforica actualizar(long id, ValidacionSemaforica datos) {
        buscarPorId(id);
        datos.setIdValidacion(id);
        evaluar(datos);
        return repositorio.guardar(datos);
    }

    @Override
    public void eliminar(long id) {
        buscarPorId(id);
        repositorio.eliminar(id);
    }

    private void evaluar(ValidacionSemaforica validacion) {
        EnsayoVariable variable = variableRepositorio.buscarPorId(validacion.getIdVariable())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Variable de ensayo no encontrada: " + validacion.getIdVariable()));

        EnsayoLaboratorio ensayo = ensayoRepositorio.buscarPorId(variable.getIdEnsayo())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Ensayo no encontrado: " + variable.getIdEnsayo()));

        ParametroCalidad parametro = resolverParametroCorrespondiente(validacion, variable, ensayo);
        validacion.setIdParametro(parametro.getIdParametro());

        validarDatos(variable, parametro);
        validarProducto(ensayo, parametro);

        BigDecimal valor = variable.getValorObtenido();
        BigDecimal minimo = parametro.getLimiteMinimo();
        BigDecimal maximo = parametro.getLimiteMaximo();

        String resultado;
        String detalle;

        if (valor.compareTo(minimo) < 0 || valor.compareTo(maximo) > 0) {
            resultado = "CRITICO";
            detalle = "fuera del rango permitido";
        } else {
            BigDecimal amplitud = maximo.subtract(minimo);
            BigDecimal margen = amplitud.multiply(PORCENTAJE_ADVERTENCIA);
            BigDecimal distanciaMinima = valor.subtract(minimo).min(maximo.subtract(valor));

            if (amplitud.compareTo(BigDecimal.ZERO) > 0 && distanciaMinima.compareTo(margen) <= 0) {
                resultado = "PRECAUCION";
                detalle = "dentro del rango, pero próximo a un límite de calidad";
            } else {
                resultado = "OPTIMO";
                detalle = "dentro del rango óptimo";
            }
        }

        validacion.setResultado(resultado);
        validacion.setMensaje(construirMensaje(variable, parametro, detalle));
        validacion.setFechaValidacion(LocalDateTime.now());
    }

    private ParametroCalidad resolverParametroCorrespondiente(
            ValidacionSemaforica validacion,
            EnsayoVariable variable,
            EnsayoLaboratorio ensayo) {

        List<ParametroCalidad> candidatos = parametroRepositorio.listarTodos().stream()
                .filter(p -> ensayo.getIdProducto() != null
                        && ensayo.getIdProducto().equals(p.getIdProducto()))
                .toList();

        if (candidatos.isEmpty()) {
            throw new IllegalArgumentException(
                    "El producto del ensayo no tiene parámetros de calidad configurados.");
        }

        // Coincidencia principal: mismo producto, nombre de variable y unidad.
        List<ParametroCalidad> exactos = candidatos.stream()
                .filter(p -> iguales(variable.getNombreVariable(), p.getNombreParametro()))
                .filter(p -> iguales(variable.getUnidadMedida(), p.getUnidadMedida()))
                .toList();

        if (exactos.size() == 1) {
            return exactos.get(0);
        }

        // Compatibilidad con datos antiguos: si la unidad identifica un único
        // parámetro del producto, puede resolverse sin confiar en el selector.
        List<ParametroCalidad> porUnidad = candidatos.stream()
                .filter(p -> iguales(variable.getUnidadMedida(), p.getUnidadMedida()))
                .toList();

        if (porUnidad.size() == 1) {
            return porUnidad.get(0);
        }

        throw new IllegalArgumentException(
                "La variable '" + variable.getNombreVariable() + "' con unidad '"
                + variable.getUnidadMedida()
                + "' no corresponde a ningún parámetro del producto del ensayo. "
                + "Elimine la variable incorrecta y regístrela usando el nombre y la unidad del parámetro configurado.");
    }

    private boolean iguales(String a, String b) {
        return tieneTexto(a) && tieneTexto(b) && a.trim().equalsIgnoreCase(b.trim());
    }

    private void validarDatos(EnsayoVariable variable, ParametroCalidad parametro) {
        if (variable.getValorObtenido() == null) {
            throw new IllegalArgumentException("La variable seleccionada no tiene un valor obtenido.");
        }
        if (parametro.getLimiteMinimo() == null || parametro.getLimiteMaximo() == null) {
            throw new IllegalArgumentException("El parámetro seleccionado no tiene límites configurados.");
        }
        if (parametro.getLimiteMinimo().compareTo(parametro.getLimiteMaximo()) > 0) {
            throw new IllegalArgumentException("El límite mínimo no puede ser mayor que el límite máximo.");
        }
        if (tieneTexto(variable.getUnidadMedida()) && tieneTexto(parametro.getUnidadMedida())
                && !variable.getUnidadMedida().trim().equalsIgnoreCase(parametro.getUnidadMedida().trim())) {
            throw new IllegalArgumentException("La unidad de la variable (" + variable.getUnidadMedida()
                    + ") no coincide con la unidad del parámetro (" + parametro.getUnidadMedida() + ").");
        }
    }

    private void validarProducto(EnsayoLaboratorio ensayo, ParametroCalidad parametro) {
        if (parametro.getIdProducto() == null || ensayo.getIdProducto() == null) {
            throw new IllegalArgumentException(
                    "No se pudo determinar el producto del ensayo o del parámetro seleccionado.");
        }
        if (!parametro.getIdProducto().equals(ensayo.getIdProducto())) {
            throw new IllegalArgumentException(
                    "El parámetro de calidad no pertenece al producto asociado al ensayo seleccionado.");
        }
    }

    private String construirMensaje(EnsayoVariable variable, ParametroCalidad parametro, String detalle) {
        String unidad = tieneTexto(parametro.getUnidadMedida()) ? " " + parametro.getUnidadMedida().trim() : "";
        return String.format("%s: valor %s%s; rango permitido [%s - %s]%s. Resultado: %s.",
                variable.getNombreVariable(),
                formatear(variable.getValorObtenido()), unidad,
                formatear(parametro.getLimiteMinimo()),
                formatear(parametro.getLimiteMaximo()), unidad,
                detalle);
    }

    private String formatear(BigDecimal valor) {
        return valor.setScale(Math.min(Math.max(valor.scale(), 0), 4), RoundingMode.HALF_UP)
                .stripTrailingZeros().toPlainString();
    }

    private boolean tieneTexto(String texto) {
        return texto != null && !texto.isBlank();
    }
}
