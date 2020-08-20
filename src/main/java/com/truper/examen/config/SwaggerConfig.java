package com.truper.examen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Configuration class for swagger-ui interface.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


  /**
   * Required bean for scanning the existing API's in project and generating the swagger-ui.
   * interface.
   */
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select()
            .apis(RequestHandlerSelectors.basePackage("com.truper.examen"))
            .build().apiInfo(apiInfo());
  }

  /**
   * Builder of the ApiInfo.
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Pedidos Truper")
            .description("API para realizar pedidos de truper")
        .version("1.0")
        .contact(new Contact("Eduardo Castillo Mendoza",
                "www.truper.com",
                "ecastillo@truper.com")).build();
  }

}