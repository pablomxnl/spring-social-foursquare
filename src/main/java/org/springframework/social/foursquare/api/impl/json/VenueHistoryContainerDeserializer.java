package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.VenueHistory;

import java.io.IOException;

public class VenueHistoryContainerDeserializer extends AbstractFoursquareDeserializer<VenueHistoryContainer> {
    @Override
    public VenueHistoryContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new VenueHistoryContainer(deserializeNestedResponseObject(jp, "venues", VenueHistory.class));
    }
}
