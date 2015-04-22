package ro.academic.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import ro.academic.constants.UrlMappings;

/**
 * Spring Security configuration class
 * @author Alexandru
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final String SECURED_URLS = "/student";
	
	
    @Autowired
	@Qualifier("userSecurityService")
	UserDetailsService userService;
    
    @Autowired
    AuthSuccessHandler authSuccess;
	
	/**
	 * Configures the data source for the login information
	 * @param auth
	 * @throws Exception
	 */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(userService);
    }
    
    /**
     * Configures the access limitations for custom urls
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
	   
        http
        .authorizeRequests()
        	.antMatchers(UrlMappings.CSS_RESOURCES_URL).permitAll()
        	.antMatchers(UrlMappings.JS_RESOURCES_URL).permitAll()
            .antMatchers(SECURED_URLS).authenticated()
            .and()
        .formLogin()
            .loginPage(UrlMappings.LOGIN_URL)
            .successHandler(authSuccess)
            .permitAll();
        
        
    }
    
}