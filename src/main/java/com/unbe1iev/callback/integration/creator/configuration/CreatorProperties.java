package com.unbe1iev.callback.integration.creator.configuration;

import org.apache.http.client.HttpClient;
import org.keycloak.authorization.client.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CreatorProperties extends Configuration {

    @Autowired
    public CreatorProperties(@Value("${keycloak.auth-server-url}") String authServerUrl,
                             @Value("${keycloak.realm}") String realm,
                             @Value("${creator-backend.client.secret}") String clientSecret) {
        this(authServerUrl, realm, "creator-backend", Map.of("secret", clientSecret), null);
    }

    private CreatorProperties(String authServerUrl, String realm, String clientId, Map<String, Object> clientCredentials, HttpClient httpClient) {
        super(authServerUrl, realm, clientId, clientCredentials, httpClient);
    }
}
