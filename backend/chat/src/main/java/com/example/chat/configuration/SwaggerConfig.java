package com.example.chat.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger config.
 *
 * @author Adam Vecsi
 * @date 2020-10-29
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.chat")).paths(PathSelectors.regex("/.*")).build()
				.apiInfo(this.apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Chat Application API descriptor.", "", "", "",
				new Contact("Adam VECSI", "", "adamvecsi94@gmail.com"), "License of API", "API license URL",
				Collections.emptyList());
	}
}
