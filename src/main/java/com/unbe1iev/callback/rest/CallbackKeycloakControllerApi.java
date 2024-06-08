package com.unbe1iev.callback.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.keycloak.events.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/keycloak")
@Tag(name = "keycloak", description = "Callback listener for events from Keycloak")
public interface CallbackKeycloakControllerApi {

    @Operation(
            summary = "Handles events propagated by Keycloak SSO",
            method = "handleKeycloakEvent",
            description = "This operation handles events propagated by Keycloak SSO.",
            tags = {"keycloak"})
    @PostMapping(value = "/events")
    ResponseEntity<Event> handleKeycloakEvent(@RequestBody Event event, @RequestHeader(name = "X-Shared-Secret") String sharedSecret);
}
