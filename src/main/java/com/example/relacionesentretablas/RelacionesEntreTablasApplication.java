package com.example.relacionesentretablas;

import com.example.relacionesentretablas.core.CustomizedExceptionHandler;
import com.example.relacionesentretablas.core.error.CustomError;
import com.example.relacionesentretablas.persona.infrastructure.controller.RestTemplate.Interceptors.LoggingRequestInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication

public class RelacionesEntreTablasApplication {

    public static void main(String[] args) {
        SpringApplication.run(RelacionesEntreTablasApplication.class, args);
    }



    @PostConstruct
    public void iniciando()
    {

    }

    @Bean
    @Qualifier
    public RestTemplate createRestTemplateInterceptor(CustomizedExceptionHandler errorHandler) {
        RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new LoggingRequestInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }



}
