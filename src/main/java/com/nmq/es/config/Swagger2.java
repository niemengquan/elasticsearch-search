package com.nmq.es.config;

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
public class Swagger2 {

    // original uri:                http://localhost:8088/swagger-ui.html
    // swagger-bootstrap-ui uri:    http://localhost:8088/doc.html

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nmq.es.api"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Shopping API")
                .contact(new Contact("niemengquan",
                        "https://www.nmq.com",
                        "niemengquan@outlook.com"))
                .description("APIs for Elasticsearch application.")
                .version("0.0.1")
                .termsOfServiceUrl("https://www.nmq.com")
                .build();
    }

}
