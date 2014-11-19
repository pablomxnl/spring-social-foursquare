package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Tip;

import java.io.IOException;

public class TipContainerDeserializer extends AbstractFoursquareDeserializer<TipContainer> {

    @Override
    public TipContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new TipContainer(deserializeNestedResponseObject(jp, "tip", Tip.class));
    }

}
