package com.example.ubersocketserver.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced // This enables service discovery for WebClient
    public WebClient.Builder loadBalancedWebClientBuilder(){
        return WebClient.builder() ;
    }

}
