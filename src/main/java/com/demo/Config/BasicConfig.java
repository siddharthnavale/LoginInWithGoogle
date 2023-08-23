package com.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.demo.Security.Oauth.CustomOAuth2UserService;
import com.demo.Security.Oauth.OAuth2LoginSuccessHandler;
import com.demo.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class BasicConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomOAuth2UserService oauthUserService;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.authorizeRequests()
		.antMatchers("/oauth2/**","/signin").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/users/")
		.and()
		.oauth2Login()
        .loginPage("/login")
        .userInfoEndpoint()
            .userService(oauthUserService)
            .and()
		 .successHandler(oAuth2LoginSuccessHandler);

	}


@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
	auth.userDetailsService(customUserDetailsService).passwordEncoder(PasswordEncoder());
	
	}

	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {

		return new BCryptPasswordEncoder(10);
	}
	


}
