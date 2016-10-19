package com.prosofi.clubmat.security;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Clase encargada de la configuración de spring MVC
 *
 * @author David Calle
 * @version 1.0
 */
@EnableWebMvc
@ComponentScan("org.springframework.security.samples.mvc")
@Configuration
@Component
class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/signin").setViewName("signin");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
}