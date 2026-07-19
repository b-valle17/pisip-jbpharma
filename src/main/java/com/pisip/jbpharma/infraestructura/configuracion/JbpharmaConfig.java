package com.pisip.jbpharma.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IProductoUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IOrdenProduccionUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IParametroCalidadUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IPlanProduccionUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IRolUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IUsuarioUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iAlertaEnsayoUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoVariableUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.aplicacion.casouso.impl.ProductoUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.AlertaEnsayoUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.EnsayoLaboratorioUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.EnsayoVariableUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.OrdenProduccionUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ParametroCalidadUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.PlanProduccionUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.RolUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.UsuarioUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ValidacionSemaforicaUseCaseImpl;
import com.pisip.jbpharma.dominio.repositorio.IProductoRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IOrdenProduccionRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IParametroCalidadRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IPlanProduccionRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IRolRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IUsuarioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iAlertaEnsayoRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoVariableRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iValidacionSemaforicaRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.AlertaEnsayoRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.EnsayoLaboratorioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.EnsayoVariableRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.OrdenProduccionRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ParametroCalidadRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.PlanProduccionRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.RolRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ValidacionSemaforicaRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IOrdenProduccionJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IParametroCalidadJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IPlanProduccionJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iAlertaEnsayojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoLaboratoriojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoVariablejpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iValidacionSemaforicajpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IProductoJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IOrdenProduccionJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IParametroCalidadJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IPlanProduccionJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IRolJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IUsuarioJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iAlertaEnsayojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoLaboratoriojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoVariablejpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iValidacionSemaforicajpaRepositorio;

@Configuration
public class JbpharmaConfig {

	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepositorio jpaRepositorio, IUsuarioJpaMapper mapper) {
		return new UsuarioRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio repositorio) {
		return new UsuarioUseCaseImpl(repositorio);
	}

	@Bean
	IRolRepositorio rolRepositorio(IRolJpaRepositorio jpaRepositorio, IRolJpaMapper mapper) {
		return new RolRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IRolUseCase rolUseCase(IRolRepositorio repositorio) {
		return new RolUseCaseImpl(repositorio);
	}

	@Bean
	IParametroCalidadRepositorio parametroCalidadRepositorio(IParametroCalidadJpaRepositorio jpaRepositorio,
			IParametroCalidadJpaMapper mapper) {
		return new ParametroCalidadRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IParametroCalidadUseCase parametroCalidadUseCase(IParametroCalidadRepositorio repositorio) {
		return new ParametroCalidadUseCaseImpl(repositorio);
	}

	@Bean
	IProductoRepositorio productoRepositorio(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper mapper) {
		return new ProductoRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IProductoUseCase productoUseCase(IProductoRepositorio repositorio) {
		return new ProductoUseCaseImpl(repositorio);
	}
	
	@Bean
	iAlertaEnsayoRepositorio alertaEnsayoRepositorio(iAlertaEnsayojpaRepositorio jpaRepositorio, iAlertaEnsayojpaMapper mapper) {
		return new AlertaEnsayoRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iAlertaEnsayoUseCase alertaEnsayoUseCase(iAlertaEnsayoRepositorio respositorio) {
		return new AlertaEnsayoUseCaseImpl(respositorio);
	}
	
	@Bean
	iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio(iEnsayoLaboratoriojpaRepositorio jpaRepositorio, iEnsayoLaboratoriojpaMapper mapper) {
		return new EnsayoLaboratorioRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iEnsayoLaboratorioUseCase EnsayoLaboratorioUseCase(iEnsayoLaboratorioRepositorio respositorio) {
		return new EnsayoLaboratorioUseCaseImpl(respositorio);
	}
	
	@Bean
	iEnsayoVariableRepositorio ensayoVariableRepositorio(iEnsayoVariablejpaRepositorio jpaRepositorio, iEnsayoVariablejpaMapper mapper) {
		return new EnsayoVariableRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iEnsayoVariableUseCase EnsayoVariableUseCase(iEnsayoVariableRepositorio respositorio) {
		return new EnsayoVariableUseCaseImpl(respositorio);
	}
	
	@Bean
	iValidacionSemaforicaRepositorio validacionSemaforicaRepositorio(iValidacionSemaforicajpaRepositorio jpaRepositorio, iValidacionSemaforicajpaMapper mapper) {
		return new ValidacionSemaforicaRepositorioImpl(jpaRepositorio, mapper);
				
	}

	@Bean
	iValidacionSemaforicaUseCase ValidacionSemaforicaUseCase(iValidacionSemaforicaRepositorio respositorio) {
		return new ValidacionSemaforicaUseCaseImpl(respositorio);
	}
	
	@Bean
	IPlanProduccionRepositorio planProduccionRepositorio(IPlanProduccionJpaRepositorio jpaRepositorio, IPlanProduccionJpaMapper mapper) {
		return new PlanProduccionRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IPlanProduccionUseCase planProduccionUseCase(IPlanProduccionRepositorio repositorio) {
		return new PlanProduccionUseCaseImpl(repositorio);
	}
	
	@Bean
	IOrdenProduccionRepositorio ordenProduccionRepositorio(IOrdenProduccionJpaRepositorio jpaRepositorio, IOrdenProduccionJpaMapper mapper) {
		return new OrdenProduccionRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IOrdenProduccionUseCase ordenProduccionUseCase(IOrdenProduccionRepositorio repositorio) {
		return new OrdenProduccionUseCaseImpl(repositorio);
	}
}