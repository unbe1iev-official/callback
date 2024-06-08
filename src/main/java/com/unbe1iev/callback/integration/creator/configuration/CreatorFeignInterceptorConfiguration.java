package com.unbe1iev.callback.integration.creator.configuration;

import com.unbe1iev.callback.integration.creator.token.CreatorAccessTokenProvider;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

public class CreatorFeignInterceptorConfiguration {

    @Bean
    public RequestInterceptor addAuthorizationHeaderRequestInterceptor(CreatorAccessTokenProvider creatorAccessTokenProvider) {
        return template -> {
            if (!template.headers().containsKey(HttpHeaders.AUTHORIZATION)) {
                template.header(HttpHeaders.AUTHORIZATION, creatorAccessTokenProvider.getBearerToken());
            }
        };
    }
}
