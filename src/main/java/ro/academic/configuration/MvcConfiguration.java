package ro.academic.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import ro.academic.constants.UrlMappings;

/**
 * Spring Mvc configuration class. This imports also security and hibernate configurations
 * @author Alexandru
 *
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "ro.academic.*" })
@Import({ SecurityConfig.class, HibernateConfiguration.class })
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	
	private final String CSS_RESOURCE_PATH = "/css/";
	private final String JS_RESOURCE_PATH = "/js/";
	private final String JSP_RESOURCE_PATH = "/WEB-INF/jsp/";
	private final String JSP_EXTENSION = ".jsp";
	
	/**
	 * Adds the resource handlers for css and js
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler(UrlMappings.CSS_RESOURCES_URL).addResourceLocations(CSS_RESOURCE_PATH);
	    registry.addResourceHandler(UrlMappings.JS_RESOURCES_URL).addResourceLocations(JS_RESOURCE_PATH);
	}
	
	/**
	 * Return a view resolver for the jsp files
	 * @return
	 */
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix(JSP_RESOURCE_PATH);
        bean.setSuffix(JSP_EXTENSION);
        return bean;
    }
    

    
}
