package com.collabera.todoapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class IMSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	//Users details
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
		
		// set of user details who can access the application
		//Uname Password
			// 0. In memory user managment
		
		auth.inMemoryAuthentication().withUser("Carter").password(passwordEncoder().encode("p")).roles("USER","ADMIN");
		
		auth.inMemoryAuthentication().withUser("Felix").password(passwordEncoder().encode("p")).roles("TEST");
		
		auth.inMemoryAuthentication().withUser("Violet").password(passwordEncoder().encode("p")).roles("ADMIN");
			// 1. Database
			// 2. LDAP
			// 3. Active Directory
			// 4. SSO
			// 5. SAML
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	//how to access URL/Resources
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/","/login","/webjars/**").permitAll().antMatchers("/*todo*").hasAnyRole("USER", "ADMIN")
		.antMatchers("/**").hasAnyRole("ADMIN").and().formLogin().loginPage("/login").defaultSuccessUrl("/", true)
		.failureUrl("/login?error=true").permitAll().and().logout().logoutSuccessUrl("/login?logout=true")
		.invalidateHttpSession(true).permitAll().and().exceptionHandling().accessDeniedPage("/forbiden").and()
		.csrf().disable();
	}
}
