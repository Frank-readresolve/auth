package fr.formation.jwtsecuredserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
// Enable or not security annotations (@Secured, @PreAuthorize, @PostAuthorize)
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    // allowedOrigin if CorsFilter declared as @Bean
    // @Value("${rncp.allowedOrigin}")
    // private String allowedOrigin;

    /**
     * Configures the HTTP security for the resource server.
     *
     * @param the HttpSecurity to configure
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
	// Disable HTTP Basic, no client authentication
	http.httpBasic().disable().csrf().disable().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		// addFilterBefore if CorsFilter declared as @Bean
		// .addFilterBefore(corsFilter(), SessionManagementFilter.class)
		// Allow OPTIONS requests (preflights)
		.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll()
		.and()
		// "/api/public/**" for anyone even anonymous
		.authorizeRequests().antMatchers("/api/public/**").permitAll()
		/*
		 * "/api/userInfo", "/api/private/**" for fully authenticated
		 * (not anonymous)
		 */
		.antMatchers("/api/userInfo", "/api/private/**")
		.authenticated();
    }
    // We can declare the CorsFilter as a @Bean
    // or @Component (see CorsFilter class)
    // @Bean
    // CorsFilter corsFilter() {
    // return new CorsFilter(allowedOrigin);
    // }
}
