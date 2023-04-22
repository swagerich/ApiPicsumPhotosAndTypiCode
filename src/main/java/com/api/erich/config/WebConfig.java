package com.api.erich.config;

import com.api.erich.client.PhotoClient;
import com.api.erich.client.TypiCodeClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebConfig {

    @Bean
    public WebClient webClient(){
        return WebClient.builder().build();
    }

    @Bean
    public PhotoClient photoClient(final WebClient webClient){
        HttpServiceProxyFactory factory = getHttpServiceProxyFactory(webClient);
        return factory.createClient(PhotoClient.class);
    }

    @Bean
    public TypiCodeClient postClient(final WebClient webClient){
        HttpServiceProxyFactory factory = getHttpServiceProxyFactory(webClient);
        return factory.createClient(TypiCodeClient.class);
    }

    private static HttpServiceProxyFactory getHttpServiceProxyFactory(WebClient webClient) {
        WebClientAdapter clientAdapter = WebClientAdapter.forClient(webClient);
        return HttpServiceProxyFactory.builder(clientAdapter).build();
    }
}
