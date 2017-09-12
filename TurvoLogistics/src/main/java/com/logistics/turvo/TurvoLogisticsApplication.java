package com.logistics.turvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

/*@Configuration
@EnableAutoConfiguration*/
@SpringBootApplication
public class TurvoLogisticsApplication {	
//public class TurvoLogisticsApplication extends SpringBootServletInitializer {
	
	/*@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(TurvoLogisticsApplication.class);
	}*/
	
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TurvoLogisticsApplication.class, args);
		DispatcherServlet dispServlet = context.getBean(DispatcherServlet.class);
		System.out.println("Disp Servlet :"+dispServlet);
		/*System.out.println("SERVLET_CONTEXT_PREFIX :"+dispServlet.SERVLET_CONTEXT_PREFIX);
		System.out.println("ContecxtConfigLocation :"+dispServlet.getContextConfigLocation());
		System.out.println("getContextAttribute :"+dispServlet.getContextAttribute());
		*/
	}
	
}


	



