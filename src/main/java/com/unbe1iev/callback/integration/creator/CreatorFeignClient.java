package com.unbe1iev.callback.integration.creator;

import com.unbe1iev.callback.integration.creator.configuration.CallbackFeignInterceptorConfiguration;
import com.unbe1iev.callback.integration.creator.dto.SignInCreatorRequestDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "creator-api",
        url = "${feign.creator.url}",
        configuration = CallbackFeignInterceptorConfiguration.class)
public interface CreatorFeignClient {

    @PostMapping(value = "/api/creators/sign-in", produces = "application/json")
    void signInNewCreator(@Valid @RequestBody SignInCreatorRequestDto signInCreatorRequestDto);
}
