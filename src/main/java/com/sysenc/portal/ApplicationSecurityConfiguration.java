package com.sysenc.portal;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private UserDetailsService adminLoginService;
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.userDetailsService(adminLoginService)
//			.passwordEncoder(passwordEncoder());
//	}
//
//
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(adminLoginService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder(11));
//		return provider;
//	}
//
//
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}


	@Override
	protected void configure(HttpSecurity http) throws Exception{
			http
				  .authorizeRequests()
//				  .antMatchers("/","/page/*","/registerForm/","/css/**","/js/**","/img/*").permitAll()
				  .antMatchers("/**","/css/**","/js/**","/img/*").permitAll()
				  .anyRequest().authenticated()
				  .and()
				  .formLogin()
				  .loginPage("/login").permitAll()
				  .and()
				  .logout().invalidateHttpSession(true)
				  .clearAuthentication(true)
				  .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				  .logoutSuccessUrl("/logout-success").permitAll();
	}



}