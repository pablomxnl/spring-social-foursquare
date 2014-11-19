package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.FoursquareUser;

import java.io.IOException;
import java.util.List;

public class RequestsContainerDeserializer extends AbstractFoursquareDeserializer<RequestsContainer> {

    @SuppressWarnings("unchecked")
    @Override
    public RequestsContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new RequestsContainer((List<FoursquareUser>) deserializeNestedList(jp, "requests", new TypeReference<List<FoursquareUser>>() {
        }));
    }

}
