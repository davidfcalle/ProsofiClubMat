package com.prosofi.clubmat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticFilesConfiguration extends WebMvcConfigurerAdapter{
	
	
	private final static String[] FRONTEND_CODE_LOCATION = {"classpath:/code/app/"};
	private final static String[] NODE_MODULES_LOCATION = {"classpath:/code/node_modules/"};
	private final static String[] IMAGES_LOCATION = {"classpath:/code/images/"};
	private final static String[] SYSTEM_JS_LOCATION = {"classpath:/code/"};
	private final static String[] PUBLIC_RES_LOCATION = {"classpath:/code/public/"};
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/app/**").addResourceLocations(FRONTEND_CODE_LOCATION).setCachePeriod(0);
		registry.addResourceHandler("/node_modules/**").addResourceLocations(NODE_MODULES_LOCATION).setCachePeriod(0);
		registry.addResourceHandler("/images/**").addResourceLocations(IMAGES_LOCATION).setCachePeriod(0);
		registry.addResourceHandler("/systemjs.config.js").addResourceLocations(SYSTEM_JS_LOCATION).setCachePeriod(0);
		registry.addResourceHandler("/public/**").addResourceLocations(PUBLIC_RES_LOCATION).setCachePeriod(0);
	}
}
