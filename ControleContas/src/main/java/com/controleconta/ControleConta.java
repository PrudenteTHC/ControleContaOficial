package com.controleconta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.controleconta.configuration.JpaConfiguration;

/**
 * Spring boot
 * @author Thiago Henrique Carvalho Prudente
 *
 */
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.controleconta"})
public class ControleConta extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ControleConta.class);
    }
	
	
	
	 public static void main(String[] args) {
	        SpringApplication.run(ControleConta.class, args);
	    }
}
