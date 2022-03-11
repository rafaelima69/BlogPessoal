package org.generatios.blogpessoal.seguranca;

import java.net.PasswordAuthentication;

import org.hibernate.internal.SessionCreationOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveUserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
public class BasicSecurityConfig  extends WebMvcConfigurerAdapter{
	
	@Autowired
	private ReactiveUserDetailsServiceAutoConfiguration UserDetailsService;
	
	@Override
	protected void configure(AuthenticateonManagerBuilder auth) throws Exception;{
		auth.userDetailsService(userDetailsService);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exceptions{
		http.authotizeRequest()
		.antMatchers("/usuario/logar").permiteAll()
		.antMatchers("/usuario/cadastrar").permiteAll()
		.antRequest().authenticated()
		.and().httpBasic()
		.and().sessionManagement().sessionCretionPolicy(SessionCreationPolicy.STATELESS)
		.and().cors()
		.and().csrf().disable();
	}

}
