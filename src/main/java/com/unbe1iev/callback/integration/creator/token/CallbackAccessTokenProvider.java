package com.unbe1iev.callback.integration.creator.token;

import com.unbe1iev.callback.integration.creator.configuration.CallbackProperties;
import com.unbe1iev.common.integration.BaseAccessTokenProvider;
import org.springframework.stereotype.Component;

@Component
public class CallbackAccessTokenProvider extends BaseAccessTokenProvider {

    public CallbackAccessTokenProvider(CallbackProperties callbackProperties) {
        super(callbackProperties);
    }
}
