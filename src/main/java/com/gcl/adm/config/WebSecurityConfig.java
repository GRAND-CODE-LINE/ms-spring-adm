package com.gcl.adm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
	public class WebSecurityConfig implements WebMvcConfigurer {





	    @Bean
	    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	        return authConfig.getAuthenticationManager();
	    }

	    @Bean
	    PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }

	    @Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.cors();
	        http.csrf().disable().authorizeHttpRequests().requestMatchers("/**").permitAll()
	        .requestMatchers("api/test/").permitAll().anyRequest().authenticated();


	        return http.build();

	    }

	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/*").allowedMethods("");
	    }

	}

