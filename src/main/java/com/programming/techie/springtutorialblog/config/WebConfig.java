package com.programming.techie.springtutorialblog.config;

import com.programming.techie.springtutorialblog.client.SlugServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {
    private final SlugServiceProperties slugServiceProperties;

    public WebConfig(SlugServiceProperties slugServiceProperties) {
        this.slugServiceProperties = slugServiceProperties;
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl(slugServiceProperties.getUrl())
                .build();
    }

    @Bean
    public SlugServiceClient slugServiceClient() {
        return HttpServiceProxyFactory.builder()
                .clientAdapter(WebClientAdapter.forClient(webClient()))
                .build()
                .createClient(SlugServiceClient.class);
    }
}
