package com.unbe1iev.callback.integration.creator.configuration;

import org.apache.http.client.HttpClient;
import org.keycloak.authorization.client.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.unbe1iev.common.util.SecurityUtil.REALM_NAME;

@Component
public class CallbackProperties extends Configuration {

    @Autowired
    public CallbackProperties(@Value("${keycloak.auth-server-url}") String authServerUrl,
                              @Value("${callback-backend.client.secret}") String clientSecret) {
        this(authServerUrl, REALM_NAME, "callback-backend", Map.of("secret", clientSecret), null);
    }

    private CallbackProperties(String authServerUrl, String realm, String clientId, Map<String, Object> clientCredentials, HttpClient httpClient) {
        super(authServerUrl, realm, clientId, clientCredentials, httpClient);
    }
}
