package com.prosofi.clubmat.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Clase encargada de la seguridad de la aplicación
 * le quita toda la seguridad a los archivos estáticos
 * y define las urls de inicio de sesión y cierre de sesión
 * @author davidfcalle
 *
 */
@EnableWebSecurity
@Configuration
public class AppSecurity extends WebSecurityConfigurerAdapter {

	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
		web
			.ignoring()
			.antMatchers("/static/**")
			.and()
			.ignoring()
			.antMatchers("/node_modules/**")
			.and()
			.ignoring()
			.antMatchers("/app/**")
			.and()
			.ignoring()
			.antMatchers("/images/**")
			.and()
			.ignoring()
			.antMatchers("/public/**")
			.and()
			.ignoring()
			.antMatchers("/systemjs.config.js");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
			.and().formLogin().loginPage("/signin").permitAll()
			.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/signin");
		http.csrf().disable(); //TODO: ojo, quitar, es para pruebas
	}

	
}
