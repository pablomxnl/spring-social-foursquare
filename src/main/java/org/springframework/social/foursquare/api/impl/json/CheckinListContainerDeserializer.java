package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.Checkin;

import java.io.IOException;
import java.util.List;

public class CheckinListContainerDeserializer extends AbstractFoursquareDeserializer<CheckinListContainer> {
    @SuppressWarnings("unchecked")
    @Override
    public CheckinListContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new CheckinListContainer((List<Checkin>) deserializeNestedList(jp, "recent", new TypeReference<List<Checkin>>() {
        }));
    }
}
