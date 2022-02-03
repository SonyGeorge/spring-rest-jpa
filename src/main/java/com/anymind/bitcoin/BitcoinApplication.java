package com.anymind.bitcoin;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@ComponentScan({"com.anymind.bitcoin.*"})
@EnableAutoConfiguration
@EnableSwagger2
@EnableAsync
public class BitcoinApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinApplication.class, args);
    }

    @Bean
    public Docket bitCoin() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("bitCoin").apiInfo(bitCoinApiInfo()).select()
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo bitCoinApiInfo() {
        return new ApiInfoBuilder().title("BitCoin Demo REST APIs").description("BitCoin Demo  APIs")
                .termsOfServiceUrl("https://anymindgroup.com/").contact(anyMindContact()).license("AnymindGroup Licensed")
                .licenseUrl("https://anymindgroup.com/").version("1.0").build();
    }

    private Contact anyMindContact() {
        return new Contact("AnyMindGroup", "https://anymindgroup.com/", "info@anymindgroup.com");
    }

}
