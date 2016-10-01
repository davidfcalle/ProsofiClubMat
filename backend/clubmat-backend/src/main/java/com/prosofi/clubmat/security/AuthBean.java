package com.prosofi.clubmat.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prosofi.clubmat.datalayer.UsuarioRepository;
import com.prosofi.clubmat.entities.Usuario;


@Configuration
public class AuthBean extends GlobalAuthenticationConfigurerAdapter{

	
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	/**
	 * funcionalidad de inciio de sesión
	 * @return
	 */
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Usuario usuario = null;
				try {
					usuario = usuarioRepository.findOneByUsuario(username);
				} catch (Exception e) {
					e.printStackTrace();
					throw new UsernameNotFoundException("El usuario " + username + " No existe");
				}
				if (usuario != null) {
					String rol = usuario.getRol();
					String[] arregloDeRoles = new String[]{rol};
					List<GrantedAuthority> rolesSeguridad = AuthorityUtils.createAuthorityList(arregloDeRoles);
					return new User( username, usuario.getContrasena(), true, true, true, true, rolesSeguridad );
				} else {
					throw new UsernameNotFoundException("Nombre de Usuario no Encontrado");
				}
			}
		};
	}
	
}
