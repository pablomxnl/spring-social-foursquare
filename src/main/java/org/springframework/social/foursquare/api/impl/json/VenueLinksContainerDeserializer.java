package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.VenueLinks;

import java.io.IOException;


public class VenueLinksContainerDeserializer extends AbstractFoursquareDeserializer<VenueLinksContainer> {
    @Override
    public VenueLinksContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new VenueLinksContainer(deserializeNestedResponseObject(jp, "links", VenueLinks.class));
    }
}
