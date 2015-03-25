package ro.academic.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Application Initializer. This is the equivalent of web.xml
 * @author Alexandru
 *
 */
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	private String DEFAULT_SERVLET_MAPPING = "/";
	
	/**
	 * Returns the configuration classes
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { MvcConfiguration.class };
	}

	/**
	 * Custom servlet Configuration classed
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	/**
	 * The Servlet mappings
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { DEFAULT_SERVLET_MAPPING };
	}

}
