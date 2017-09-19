package com.logistics.turvo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource; //Data Soruce Bean has been configured in .properties files
	
	@Autowired
	private  BCryptPasswordEncoder passwordEncoder;

		@Autowired
	    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
	  	//public void Configure(AuthenticationManagerBuilder auth) throws Exception {
	  		/*auth.inMemoryAuthentication().withUser("jimi").password("hindrik").roles("USER")
			.and()
			.withUser("admin").password("admin").roles("USER","ADMIN");  */
	  		
		  auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery("select name,password, active from users where name=?")
		  .authoritiesByUsernameQuery("select username, authority from authorities where username=?")
		  .passwordEncoder(passwordEncoder);
		 
	  	}
  
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
         	.antMatchers("/", "/index").hasRole("USER")
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login").failureUrl("/login?error")
             .usernameParameter("username")
             .passwordParameter("password")
             .permitAll()
             .and()
         .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
         	.and()
         .exceptionHandling()
         .accessDeniedPage("/403");
      
         //.permitAll();
	}
	  
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder(){
		 return new BCryptPasswordEncoder();
	  }
      
      /*
      @Bean
      public Md5PasswordEncoder pass(){
    	return new Md5PasswordEncoder();  
      } */
}
