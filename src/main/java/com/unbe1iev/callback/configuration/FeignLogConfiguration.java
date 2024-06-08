package com.unbe1iev.callback.configuration;

import feign.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class FeignLogConfiguration {

    @Bean
    Logger feignLogger() {
        return new Logger() {

            @Override
            protected void log(String configKey, String format, Object... args) {
                log.info(String.format(format, args));
            }
        };
    }

    @Bean
    Logger.Level feignLoggerLevel(@Value("${feign.log.level:BASIC}") String logLevel) {
        return Logger.Level.valueOf(logLevel);
    }
}

