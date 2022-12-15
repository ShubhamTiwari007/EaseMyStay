package com.stackroute.chatservice.configuration;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.function.Predicate;

@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select().apis(Predicate.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .build();
    }


    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Ease My Stay : Chat Service",
                "This service is for Chat.",
                "v1.0.0",
                "Terms of Service",
                new Contact(
                        "Stevenson", "",
                        "swastika.shanker@globallogic.com"
                ),
                "License of APIS",
                "API license URL",
                Collections.emptyList()
        );
    }
}