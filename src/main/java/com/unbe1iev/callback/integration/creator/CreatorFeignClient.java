package com.unbe1iev.callback.integration.creator;

import com.unbe1iev.callback.integration.creator.configuration.CreatorFeignInterceptorConfiguration;
import com.unbe1iev.callback.integration.creator.dto.SignInCreatorRequestDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "creator-api",
        url = "${feign.creator.url}",
        configuration = CreatorFeignInterceptorConfiguration.class)
public interface CreatorFeignClient {

    @PostMapping(value = "/creators/sign-in", consumes = "application/json", produces = "application/json")
    void signInNewCreator(@Valid @RequestBody SignInCreatorRequestDto signInCreatorRequestDto,
                          @RequestHeader("Authorization") String token);
}
