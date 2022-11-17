package com.newtoninvestments.productlist.configuration;

import com.newtoninvestments.productlist.ProductListApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig {

        @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(
                new ApiInfoBuilder()
                    .title("product-list")
                    .description("Service for check list products")
                    .build()
            )
            .select()
            .apis(
                RequestHandlerSelectors.basePackage(ProductListApplication.class.getPackageName()))
            .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
            .build();
    }
}
