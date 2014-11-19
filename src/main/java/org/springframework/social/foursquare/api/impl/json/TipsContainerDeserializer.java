package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Tips;

import java.io.IOException;

public class TipsContainerDeserializer extends AbstractFoursquareDeserializer<TipsContainer> {
    @Override
    public TipsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new TipsContainer(deserializeNestedResponseObject(jp, "tips", Tips.class));
    }
}
