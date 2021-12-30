package com.bortherx.upload.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;

/**
 * Created by MAC M1.
 *
 * @Author: Ax.
 * @Date: 2021/12/30.
 * @Description: SwaggerConfig.
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).enable(true)
                .select()
                //apis： 添加swagger接口提取范围
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("borther-xiang springboot upload项目接口文档")
                .description("upload项目描述")
                .contact(new Contact("borther-xiang", "borther-xiang", "borther-xiang"))
                .version("1.0")
                .build();
    }
}
