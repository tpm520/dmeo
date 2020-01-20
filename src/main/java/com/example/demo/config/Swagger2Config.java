package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	/**
	 * 添加摘要信息
	 */
	@Bean
	public Docket controllerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("用户相关api")
				.apiInfo(new ApiInfoBuilder()
						.title("博物馆管理系统")
						.description("用于管理博物馆信息")
						.contact(new Contact("tp",null,null))
						.version("1.1.1")
						.build())
				.select() // 选择哪些路径和方法会生成api文档
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
				.paths(PathSelectors.any())// 对所有路径进行监控
				.build();
	}
}
