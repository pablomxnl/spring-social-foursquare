package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Photos;

import java.io.IOException;

public class VenuePhotosContainerDeserializer extends AbstractFoursquareDeserializer<VenuePhotosContainer> {
    @Override
    public VenuePhotosContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new VenuePhotosContainer(deserializeNestedResponseObject(jp, "photos", Photos.class));
    }
}
