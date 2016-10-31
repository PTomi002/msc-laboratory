package hu.bme.msc.onlab.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = { "hu.bme.msc.onlab.controller" , "hu.bme.msc.onlab.service", "hu.bme.msc.onlab.dao"})
//Replaces root-servlet.xml when using XML-based config
public class MvcWebAppConfiguration extends WebMvcConfigurerAdapter {
	private static final String ROOT_SERVLET_NAME = "root";

	//	----------------------------------------------
//	----------------------------------------------
//	||		Setting default config				||
//	----------------------------------------------		
//	----------------------------------------------
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/public/**").addResourceLocations("/public/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		Set default servlet name to "root"
		configurer.enable(ROOT_SERVLET_NAME);
	}
}