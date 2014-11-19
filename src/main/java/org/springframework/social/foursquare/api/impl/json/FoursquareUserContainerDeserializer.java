package org.springframework.social.foursquare.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import org.springframework.social.foursquare.api.FoursquareUser;

import java.io.IOException;

public class FoursquareUserContainerDeserializer extends AbstractFoursquareDeserializer<FoursquareUserContainer> {

    @Override
    public FoursquareUserContainer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return new FoursquareUserContainer(deserializeNestedResponseObject(jp, "user", FoursquareUser.class));
    }


}
