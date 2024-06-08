package com.unbe1iev.callback.rest.impl;

import com.unbe1iev.callback.rest.CallbackKeycloakControllerApi;
import com.unbe1iev.callback.service.CallbackKeycloakService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.events.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CallbackKeycloakController implements CallbackKeycloakControllerApi {

    private final CallbackKeycloakService callbackKeycloakService;

    @Override
    public ResponseEntity<Event> handleKeycloakEvent(Event event, String sharedSecret) {
        log.info("An event was received: {}", event);
        callbackKeycloakService.handleKeycloakEvent(event, sharedSecret);
        return ResponseEntity.ok(event);
    }
}
