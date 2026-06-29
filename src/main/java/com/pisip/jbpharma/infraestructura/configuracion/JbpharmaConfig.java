package com.pisip.jbpharma.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.pisip.jbpharma.aplicacion.casouso.entrada.IProductoUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IAuditoriaLoteUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IDictamenLoteUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IHistorialLoteUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IIndicadorKpiUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IInformeAuditoriaUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IOrdenProduccionUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IParametroCalidadUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IPlanProduccionUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IRolUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.IUsuarioUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iAlertaEnsayoUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoLaboratorioUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iEnsayoVariableUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iParametroValidacionUseCase;
import com.pisip.jbpharma.aplicacion.casouso.entrada.iValidacionSemaforicaUseCase;
import com.pisip.jbpharma.aplicacion.casouso.impl.ProductoUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.AlertaEnsayoUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.AuditoriaLoteUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.DictamenLoteUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.EnsayoLaboratorioUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.EnsayoVariableUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.HistorialLoteUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.IndicadorKpiUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.InformeAuditoriaUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.OrdenProduccionUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ParametroCalidadUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ParametroValidacionUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.PlanProduccionUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.RolUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.UsuarioUseCaseImpl;
import com.pisip.jbpharma.aplicacion.casouso.impl.ValidacionSemaforicaUseCaseImpl;
import com.pisip.jbpharma.dominio.repositorio.IProductoRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IAuditoriaLoteRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IDictamenLoteRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IHistorialLoteRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IIndicadorKpiRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IInformeAuditoriaRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IOrdenProduccionRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IParametroCalidadRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IPlanProduccionRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IRolRepositorio;
import com.pisip.jbpharma.dominio.repositorio.IUsuarioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iAlertaEnsayoRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoLaboratorioRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iEnsayoVariableRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iParametroValidacionRepositorio;
import com.pisip.jbpharma.dominio.repositorio.iValidacionSemaforicaRepositorio;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.AlertaEnsayoRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.AuditoriaLoteRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.DictamenLoteRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.EnsayoLaboratorioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.EnsayoVariableRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.HistorialLoteRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.IndicadorKpiRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.InformeAuditoriaRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.OrdenProduccionRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ParametroCalidadRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ParametroValidacionRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.PlanProduccionRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.RolRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.UsuarioRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.adaptadores.ValidacionSemaforicaRepositorioImpl;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IAuditoriaLoteJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IDictamenLoteJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IHistorialLoteJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IIndicadorKpiJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IInformeAuditoriaJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IOrdenProduccionJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IParametroCalidadJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IPlanProduccionJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IRolJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.IUsuarioJpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iAlertaEnsayojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoLaboratoriojpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iEnsayoVariablejpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iParametroValidacionjpaMapper;
import com.pisip.jbpharma.infraestructura.persistencia.mapeadores.iValidacionSemaforicajpaMapper;
import com.pisip.jbpharma.infraestructura.repositorio.IProductoJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IAuditoriaLoteJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IDictamenLoteJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IHistorialLoteJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IIndicadorKpiJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IInformeAuditoriaJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IOrdenProduccionJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IParametroCalidadJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IPlanProduccionJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IRolJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.IUsuarioJpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iAlertaEnsayojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoLaboratoriojpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iEnsayoVariablejpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iParametroValidacionjpaRepositorio;
import com.pisip.jbpharma.infraestructura.repositorio.iValidacionSemaforicajpaRepositorio;

@Configuration
@EnableWebSecurity
public class JbpharmaConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/api/usuarios", "/api/usuarios/login", "/api/productos",
								"/api/parametros-calidad", "/api/productos/**", "/api/parametros-calidad/**")
						.permitAll().anyRequest().authenticated());

		return http.build();
	}

	@Bean
	IUsuarioRepositorio usuarioRepositorio(IUsuarioJpaRepositorio jpaRepositorio, IUsuarioJpaMapper mapper) {
		return new UsuarioRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IUsuarioUseCase usuarioUseCase(IUsuarioRepositorio repositorio, PasswordEncoder passwordEncoder) {
		return new UsuarioUseCaseImpl(repositorio, passwordEncoder);
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
	iAlertaEnsayoRepositorio alertaEnsayoRepositorio(iAlertaEnsayojpaRepositorio jpaRepositorio,
			iAlertaEnsayojpaMapper mapper) {
		return new AlertaEnsayoRepositorioImpl(jpaRepositorio, mapper);

	}

	@Bean
	iAlertaEnsayoUseCase alertaEnsayoUseCase(iAlertaEnsayoRepositorio respositorio) {
		return new AlertaEnsayoUseCaseImpl(respositorio);
	}

	@Bean
	iEnsayoLaboratorioRepositorio ensayoLaboratorioRepositorio(iEnsayoLaboratoriojpaRepositorio jpaRepositorio,
			iEnsayoLaboratoriojpaMapper mapper) {
		return new EnsayoLaboratorioRepositorioImpl(jpaRepositorio, mapper);

	}

	@Bean
	iEnsayoLaboratorioUseCase EnsayoLaboratorioUseCase(iEnsayoLaboratorioRepositorio respositorio) {
		return new EnsayoLaboratorioUseCaseImpl(respositorio);
	}

	@Bean
	iEnsayoVariableRepositorio ensayoVariableRepositorio(iEnsayoVariablejpaRepositorio jpaRepositorio,
			iEnsayoVariablejpaMapper mapper) {
		return new EnsayoVariableRepositorioImpl(jpaRepositorio, mapper);

	}

	@Bean
	iEnsayoVariableUseCase EnsayoVariableUseCase(iEnsayoVariableRepositorio respositorio) {
		return new EnsayoVariableUseCaseImpl(respositorio);
	}

	@Bean
	iParametroValidacionRepositorio parametroValidacionRepositorio(iParametroValidacionjpaRepositorio jpaRepositorio,
			iParametroValidacionjpaMapper mapper) {
		return new ParametroValidacionRepositorioImpl(jpaRepositorio, mapper);

	}

	@Bean
	iParametroValidacionUseCase ParametroValidacionUseCase(iParametroValidacionRepositorio respositorio) {
		return new ParametroValidacionUseCaseImpl(respositorio);
	}

	@Bean
	iValidacionSemaforicaRepositorio validacionSemaforicaRepositorio(iValidacionSemaforicajpaRepositorio jpaRepositorio,
			iValidacionSemaforicajpaMapper mapper) {
		return new ValidacionSemaforicaRepositorioImpl(jpaRepositorio, mapper);

	}

	@Bean
	iValidacionSemaforicaUseCase ValidacionSemaforicaUseCase(iValidacionSemaforicaRepositorio respositorio) {
		return new ValidacionSemaforicaUseCaseImpl(respositorio);
	}

	@Bean
	IPlanProduccionRepositorio planProduccionRepositorio(IPlanProduccionJpaRepositorio jpaRepositorio,
			IPlanProduccionJpaMapper mapper) {
		return new PlanProduccionRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IPlanProduccionUseCase planProduccionUseCase(IPlanProduccionRepositorio repositorio) {
		return new PlanProduccionUseCaseImpl(repositorio);
	}

	@Bean
	IOrdenProduccionRepositorio ordenProduccionRepositorio(IOrdenProduccionJpaRepositorio jpaRepositorio,
			IOrdenProduccionJpaMapper mapper) {
		return new OrdenProduccionRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IOrdenProduccionUseCase ordenProduccionUseCase(IOrdenProduccionRepositorio repositorio) {
		return new OrdenProduccionUseCaseImpl(repositorio);
	}

	@Bean
	IAuditoriaLoteRepositorio auditoriaLoteRepositorio(IAuditoriaLoteJpaRepositorio jpaRepositorio,
			IAuditoriaLoteJpaMapper mapper) {
		return new AuditoriaLoteRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IAuditoriaLoteUseCase auditoriaLoteUseCase(IAuditoriaLoteRepositorio repositorio) {
		return new AuditoriaLoteUseCaseImpl(repositorio);
	}

	@Bean
	IDictamenLoteRepositorio dictamenLoteRepositorio(IDictamenLoteJpaRepositorio jpaRepositorio,
			IDictamenLoteJpaMapper mapper) {
		return new DictamenLoteRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IDictamenLoteUseCase dictamenLoteUseCase(IDictamenLoteRepositorio repositorio) {
		return new DictamenLoteUseCaseImpl(repositorio);
	}

	@Bean
	IHistorialLoteRepositorio historialLoteRepositorio(IHistorialLoteJpaRepositorio jpaRepositorio,
			IHistorialLoteJpaMapper mapper) {
		return new HistorialLoteRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IHistorialLoteUseCase historialLoteUseCase(IHistorialLoteRepositorio repositorio) {
		return new HistorialLoteUseCaseImpl(repositorio);
	}

	@Bean
	IInformeAuditoriaRepositorio informeAuditoriaRepositorio(IInformeAuditoriaJpaRepositorio jpaRepositorio,
			IInformeAuditoriaJpaMapper mapper) {
		return new InformeAuditoriaRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IInformeAuditoriaUseCase informeAuditoriaUseCase(IInformeAuditoriaRepositorio repositorio) {
		return new InformeAuditoriaUseCaseImpl(repositorio);
	}

	@Bean
	IIndicadorKpiRepositorio indicadorKpiRepositorio(IIndicadorKpiJpaRepositorio jpaRepositorio,
			IIndicadorKpiJpaMapper mapper) {
		return new IndicadorKpiRepositorioImpl(jpaRepositorio, mapper);
	}

	@Bean
	IIndicadorKpiUseCase indicadorKpiUseCase(IIndicadorKpiRepositorio repositorio) {
		return new IndicadorKpiUseCaseImpl(repositorio);
	}
}