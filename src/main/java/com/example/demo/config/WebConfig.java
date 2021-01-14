package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;




/**
* Configuration class intended for Spring MVC (template resolution 
* etc.)
 * @param <ClassLoaderTemplateResolver>
*/
@Configuration

public class WebConfig implements WebMvcConfigurer  {
	
//	@Bean: Indicates that a method produces a bean to be managed by the Spring container. 

	 @Bean
	    @Description("Thymeleaf template resolver serving HTML 5")
	    public ClassLoaderTemplateResolver templateResolver() {

	        ClassLoaderTemplateResolver tres = new ClassLoaderTemplateResolver();

	     //   tres.setPrefix("WEB-INF/views/");
	        tres.setPrefix("templates/");
	        tres.setSuffix(".html");        
	        tres.setCacheable(false);
	       
	        tres.setTemplateMode("HTML5");
	        tres.setCharacterEncoding("UTF-8");
	        
	        return tres;
	    }
	
	

}
