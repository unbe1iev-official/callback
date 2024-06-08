package com.unbe1iev.callback.integration.creator.token;

import com.unbe1iev.callback.integration.creator.configuration.CreatorProperties;
import com.unbe1iev.common.integration.BaseAccessTokenProvider;
import org.springframework.stereotype.Component;

@Component
public class CreatorAccessTokenProvider extends BaseAccessTokenProvider {

    public CreatorAccessTokenProvider(CreatorProperties creatorProperties) {
        super(creatorProperties);
    }
}
