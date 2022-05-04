package com.project.professorallocation.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.professorallocation.ProfessorAllocationAmirtonApplication;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select() 
                .apis(RequestHandlerSelectors.basePackage(ProfessorAllocationAmirtonApplication.class.getPackage().getName()))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
    		String version = null;
    	
    		try {
	    		MavenXpp3Reader reader = new MavenXpp3Reader();
	        Model model = reader.read(new FileReader("pom.xml"));
	        version = model.getVersion();
    		} catch (Exception ex) {
    			System.out.println("Error reading pom.xml");
    		}
        
        return new ApiInfoBuilder()
                .title("Professor Allocation")
                .description("Professor Allocation Rest Server")
                .version(version)
                .build();
    }
}