package com.unbe1iev.callback.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ObjectToJsonMapper {

    private final ObjectMapper objectMapper;

    public String map(Object inputObject) {
        try {
            return objectMapper.writeValueAsString(inputObject);
        } catch (JsonProcessingException exception) {
            log.error("ObjectMapper issue: {0}", exception);
            return inputObject.toString();
        }
    }
}
