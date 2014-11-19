package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.CheckinInfo;

import java.io.IOException;

public class CheckinInfoContainerDeserializer extends AbstractFoursquareDeserializer<CheckinInfoContainer> {
    @Override
    public CheckinInfoContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new CheckinInfoContainer(deserializeNestedResponseObject(jp, "checkins", CheckinInfo.class));
    }
}