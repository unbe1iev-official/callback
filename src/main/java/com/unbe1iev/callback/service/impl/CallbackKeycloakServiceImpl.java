package com.unbe1iev.callback.service.impl;

import com.unbe1iev.callback.integration.creator.CreatorFeignClient;
import com.unbe1iev.callback.integration.creator.dto.SignInCreatorRequestDto;
import com.unbe1iev.callback.mapper.ObjectToJsonMapper;
import com.unbe1iev.callback.service.CallbackKeycloakService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.events.Event;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CallbackKeycloakServiceImpl implements CallbackKeycloakService {

    @Value("${custom.event.listener.shared.secret}")
    private String configuredSharedSecretKey;
    private final CreatorFeignClient creatorFeignClient;
    private final ObjectToJsonMapper objectToJsonMapper;

    private static final String REGISTER_EVENT_TYPE = "REGISTER";

    @Override
    public void handleKeycloakEvent(Event event, String sharedSecret) {
        log.info("Received event: {}", objectToJsonMapper.map(event));

        if (sharedSecret == null || !sharedSecret.equals(configuredSharedSecretKey)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid shared secret");
        }

        if (REGISTER_EVENT_TYPE.equals(event.getType().toString())) {
            creatorFeignClient.signInNewCreator(
                    SignInCreatorRequestDto.builder()
                            .keycloakId(event.getUserId())
                            .username(event.getDetails().get("username"))
                            .email(event.getDetails().get("email"))
                            .firstName(event.getDetails().getOrDefault("first_name", null))
                            .lastName(event.getDetails().getOrDefault("last_name", null))
                            .build());
            log.info("Sending to creator service...");
        }
    }
}
