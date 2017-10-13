package com.acnovate.hexm.ppm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class PPMSwaggerConfig {

	private static final String API_TITLE = "Project-Process Management";
	private static final String API_DESCRIPTION = "API for Process Management Tool";
	private static final String API_VERSION = "1.0.0";
	private static final String API_CONTACT_NAME = "Shreekanth Nair";
	private static final String API_CONTACT_URL = "www.facebook.com/shreekanth.nair";
	private static final String API_CONTACT_EMAIL = "shreekanth.nair@acnovate.com";
	private static final String API_LICENSE = "Apache Open Source License";
	private static final String API_LICENSE_URL = "www.apache.org";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("hexm-services").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.acnovate.hexm.ppm.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title(API_TITLE).description(API_DESCRIPTION).version(API_VERSION)
				.contact(new Contact(API_CONTACT_NAME, API_CONTACT_URL, API_CONTACT_EMAIL)).license(API_LICENSE)
				.licenseUrl(API_LICENSE_URL).build();
	}
}
