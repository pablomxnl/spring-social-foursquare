package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.BadgesResponse;

import java.io.IOException;

public class BadgesResponseContainerDeserializer extends AbstractFoursquareDeserializer<BadgesResponseContainer> {
    @Override
    public BadgesResponseContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return deserializeResponseObject(jp, BadgesResponseContainer.class, BadgesResponse.class);
    }
}
