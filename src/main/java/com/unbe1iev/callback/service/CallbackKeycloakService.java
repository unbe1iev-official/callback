package com.unbe1iev.callback.service;

import org.keycloak.events.Event;

public interface CallbackKeycloakService {
    void handleKeycloakEvent(Event event, String sharedSecret);
}
