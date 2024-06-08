package com.unbe1iev.callback.integration.creator.configuration;

import com.unbe1iev.callback.integration.creator.token.CallbackAccessTokenProvider;
import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

public class CallbackFeignInterceptorConfiguration {

    public static final String X_DOMAIN_HEADER = "X-DOMAIN";

    @Value("${domain.name}")
    private String domain;

    @Bean
    public RequestInterceptor addAuthorizationHeaderRequestInterceptor(CallbackAccessTokenProvider callbackAccessTokenProvider) {
        return template -> {
            if (!template.headers().containsKey(HttpHeaders.AUTHORIZATION)) {
                template.header(HttpHeaders.AUTHORIZATION, callbackAccessTokenProvider.getBearerToken());
            }

            if (!template.headers().containsKey(X_DOMAIN_HEADER)) {
                template.header(X_DOMAIN_HEADER, domain);
            }
        };
    }
}