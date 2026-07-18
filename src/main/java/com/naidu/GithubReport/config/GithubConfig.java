package com.naidu.GithubReport.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GithubConfig {

    @Value("${github.token}")
    private String token;
    @Value("${github.organization}")
    private String organization;
    
    public String getToken(){
        return token;
    }

    public String getOrganisation(){
        return organization;
    }

    @Bean
    public RestClient restClient(){
        return RestClient.builder().build();
    }
}

