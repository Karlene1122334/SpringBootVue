package com.example.springbootandvue;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition
@MapperScan("com.example.springbootandvue.mapper")
public class SpringbootAndVueApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAndVueApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI(@Value("springdoc.1.6.9") String appVersion) {
        return new OpenAPI()
                .components(new Components())
                .info(
                        new Info()
                                .title("SPRINGVUE")
                                .version(appVersion)
                                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}