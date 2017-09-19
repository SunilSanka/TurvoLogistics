
package com.logistics.turvo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
//applicationContext.xml
	
	 @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	 
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry){
		//registry.addResourceHandler("/*.js/**").addResourceLocations("/");
       // registry.addResourceHandler("/*.css/**").addResourceLocations("/");
       registry.addResourceHandler("/*.js/**").addResourceLocations("/WEB-INF/js/");
       /* registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");*/
        registry.addResourceHandler("/*.jpg/**").addResourceLocations("/WEB-INF/images/");
	} 

	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/").setViewName("login");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/index").setViewName("index");
		registry.addViewController("/logout").setViewName("logout");
		registry.addViewController("/403").setViewName("403");
		
		registry.addViewController("/registerUser").setViewName("registerUser");
		
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	} 
	
	/*
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
	return resolver;
	} 
*/	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		registry.viewResolver(resolver);
	}
	
}

