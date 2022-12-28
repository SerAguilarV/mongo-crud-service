package com.mx.saguilarv.mongocrudservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration

public class SpringFoxConfig {
    
    @Bean
    public RestTemplate getRestTemplate() {
        ClientHttpRequestFactory factory
                = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        RestTemplate restTemplate = new RestTemplate(factory);
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    @Bean
    public GroupedOpenApi api(/* TypeResolver resolver */) {
    return GroupedOpenApi.builder()
            .group("docs")
            .pathsToMatch("/**")
            .build();        
        }


    @Bean
    public OpenAPI apiInfo() {
        Contact contact = new Contact();
        contact.setName("The developer");
        contact.setEmail("icalderah@findep.com.mx");
        return new OpenAPI()
                .info(new Info()
                .title("State Machine Microservice")
                .description("Management Canales -> State Machine")
                .version("1.0")
                .contact(contact)
                .license(new License().name("FINDEP 1.0").url("http://springdoc.org")))
                /* .externalDocs(new ExternalDocumentation()
                .description("Servicio que obtiene los comprobantes CEP de Banxico")
                .url("http://springshop.wiki.github.org/docs")) */;
    }   
}
