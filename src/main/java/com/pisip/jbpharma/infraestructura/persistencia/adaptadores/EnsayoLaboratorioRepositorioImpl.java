package com.pisip.jbpharma.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.pisip.jbpharma.dominio.entidades.EnsayoLaboratorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.jpa.EnsayoLaboratorioEntity;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoLaboratoriojpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoLaboratoriojpaRepositorio;

public class EnsayoLaboratorioRepositorioImpl implements iEnsayoLaboratorioRepositorio {

	private final iEnsayoLaboratoriojpaRepositorio jpaRepositorio;
	private final iEnsayoLaboratoriojpaMapper entityMapper;

	public EnsayoLaboratorioRepositorioImpl(iEnsayoLaboratoriojpaRepositorio jpaRepositorio,
			iEnsayoLaboratoriojpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public EnsayoLaboratorio guardar(EnsayoLaboratorio nuevoEnsayoLaboratorio) {
		EnsayoLaboratorioEntity entidad = entityMapper.toEntity(nuevoEnsayoLaboratorio);
		EnsayoLaboratorioEntity guardado = jpaRepositorio.save(entidad);
		return entityMapper.toDominio(guardado);
	}

	@Override
<<<<<<< Updated upstream
	public Optional<EnsayoLaboratorio> buscarPorId(int idEnsayoLaboratorio) {
		return jpaRepositorio.findById(idEnsayoLaboratorio).map(entityMapper :: toDominio);
=======
	public Optional<EnsayoLaboratorio> buscarPorId(long idEnsayoLaboratorio) {
		return jpaRepositorio.findById(idEnsayoLaboratorio).map(entityMapper::toDominio);
>>>>>>> Stashed changes
	}

	@Override
	public List<EnsayoLaboratorio> listarTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDominio).toList();
	}

	@Override
	public void eliminar(int idEnsayoLaboratorio) {
		jpaRepositorio.deleteById(idEnsayoLaboratorio);
	}

	@Override
	public Optional<EnsayoLaboratorio> buscarPorIdOrden(int idOrden) {
		return jpaRepositorio.findByOrdenProduccion_IdOrdenOrderByFechaEnsayoDesc(idOrden)
				.stream()
				.findFirst()
				.map(entityMapper::toDominio);
	}
}
