package com.cibertec.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cibertec.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@CrossOrigin(origins = "*")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	//Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
	        .antMatchers(resources).permitAll()  
	        .antMatchers("/","/index").permitAll()
	        .antMatchers(HttpMethod.GET,"/personas").permitAll()
	        .antMatchers(HttpMethod.POST,"/personas").permitAll()
	        .antMatchers(HttpMethod.PUT,"/personas").permitAll()
	        .antMatchers(HttpMethod.DELETE,"/personas/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/paises").permitAll()
	        .antMatchers(HttpMethod.POST,"/paises").permitAll()
	        .antMatchers(HttpMethod.PUT,"/paises").permitAll()
	        .antMatchers(HttpMethod.DELETE,"/paises/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/ciudades").permitAll()
	        .antMatchers(HttpMethod.POST,"/ciudades").permitAll()
	        .antMatchers(HttpMethod.PUT,"/ciudades").permitAll()
	        .antMatchers(HttpMethod.DELETE,"/ciudades/*").permitAll()
	        .antMatchers(HttpMethod.GET,"/provincias/*").permitAll()
	        .antMatchers(HttpMethod.POST,"/provincias").permitAll()
	        .antMatchers(HttpMethod.PUT,"/provincias").permitAll()
	        .antMatchers(HttpMethod.DELETE,"/provincias/*").permitAll()
	        .antMatchers("/admin*").access("hasRole('ADMIN')")
	        .antMatchers("/user*").access("hasRole('USER') or hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
            .csrf().disable()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/inicio")
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
            .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");
    }
    BCryptPasswordEncoder bCryptPasswordEncoder;
    //Crea el encriptador de contraseñas	
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
//El numero 4 representa que tan fuerte quieres la encriptacion.
//Se puede en un rango entre 4 y 31. 
//Si no pones un numero el programa utilizara uno aleatoriamente cada vez
//que inicies la aplicacion, por lo cual tus contrasenas encriptadas no funcionaran bien
        return bCryptPasswordEncoder;
    }
	
    @Autowired
    UserDetailsServiceImpl userDetailsService;
	
    //Registra el service para usuarios y el encriptador de contrasena
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());     
    }
}