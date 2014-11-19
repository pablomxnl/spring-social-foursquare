package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;

import java.io.IOException;


public class BooleanValueContainerDeserializer extends AbstractFoursquareDeserializer<BooleanValueContainer> {
    @Override
    public BooleanValueContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new BooleanValueContainer(deserializeNestedResponseObject(jp, "value", Boolean.class));
    }
}
