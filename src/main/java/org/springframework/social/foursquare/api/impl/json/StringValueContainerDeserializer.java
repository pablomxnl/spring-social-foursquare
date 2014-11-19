package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;


public class StringValueContainerDeserializer extends AbstractFoursquareDeserializer<StringValueContainer> {
    @Override
    public StringValueContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new StringValueContainer(deserializeNestedResponseObject(jp, "message", String.class));
    }
}

