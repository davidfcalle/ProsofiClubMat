package com.prosofi.clubmat.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.prosofi.clubmat.entities.Clubmatematicas;
import com.prosofi.clubmat.entities.Guia;
import com.prosofi.clubmat.entities.Institucion;
import com.prosofi.clubmat.entities.Noticia;
import com.prosofi.clubmat.entities.Olimpiada;
import com.prosofi.clubmat.entities.Opcionpregunta;
import com.prosofi.clubmat.entities.Pregunta;
import com.prosofi.clubmat.entities.Prueba;
import com.prosofi.clubmat.entities.Reglacreacion;
import com.prosofi.clubmat.entities.Usuario;
import com.prosofi.clubmat.entities.UsuarioOlimpiada;
import com.prosofi.clubmat.projections.OlimpiadaFullProjection;
import com.prosofi.clubmat.projections.PreguntaOpcionProjection;


/**
 * clase encargada de la configuración del api rest de la aplicación
 * @author davidfcalle
 *
 */
@Configuration
public class RestApiConfiguration {
	
	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {

		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				
				config.setBasePath("/api");
				config.exposeIdsFor(Clubmatematicas.class);
				config.exposeIdsFor(Guia.class);
				config.exposeIdsFor(Institucion.class);
				config.exposeIdsFor(Noticia.class);
				config.exposeIdsFor(Olimpiada.class);
				config.exposeIdsFor(Opcionpregunta.class);
				config.exposeIdsFor(Pregunta.class);
				config.exposeIdsFor(Prueba.class);
				config.exposeIdsFor(Reglacreacion.class);
				config.exposeIdsFor(Usuario.class);
				config.exposeIdsFor(UsuarioOlimpiada.class);
			    // registro de proyecciones
			    config.getProjectionConfiguration().addProjection(PreguntaOpcionProjection.class);
			    config.getProjectionConfiguration().addProjection(OlimpiadaFullProjection.class);
			}

			@Override
			public void configureConversionService(ConfigurableConversionService conversionService) {
				super.configureConversionService( conversionService );
			}
		};
	}
}
