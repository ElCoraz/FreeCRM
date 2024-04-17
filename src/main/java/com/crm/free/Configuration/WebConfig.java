package com.crm.free.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    /*@SuppressWarnings("deprecation")
    @Override
    public void configureContentNegotiation(@SuppressWarnings("null") ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("com", MediaType.APPLICATION_JSON);
    }*/
}