package pl.javastart.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return passwordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .authorizeRequests()
	            .antMatchers("/").permitAll()
	            .antMatchers("/addpupil")
	           .authenticated()
	            .anyRequest().permitAll()
	        .and()
	        .formLogin()
	            .loginPage("/loginform")
	                .permitAll()
	            .loginProcessingUrl("/processlogin")
	                .permitAll()
	            .usernameParameter("username")
	            .passwordParameter("password")
	            .and()
	        .logout()
	            .logoutUrl("/logmeout")
	                .logoutSuccessUrl("/")
	                .permitAll();
	    
	}
	
}